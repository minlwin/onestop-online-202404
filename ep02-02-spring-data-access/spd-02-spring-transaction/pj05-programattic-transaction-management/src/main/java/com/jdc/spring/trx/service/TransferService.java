package com.jdc.spring.trx.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.jdc.spring.trx.exceptions.TransferException;
import com.jdc.spring.trx.service.dto.AccountDto;
import com.jdc.spring.trx.service.dto.TransferForm;

@Service
public class TransferService {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private PlatformTransactionManager trxManager;
	
	public int transfer(TransferForm form) {
		int historyId = 0;
		
		// Start Transaction
		var histroyTrx = trxManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			historyId = createHistory(form);
			trxManager.commit(histroyTrx);
		} catch (Exception e) {
			trxManager.rollback(histroyTrx);
			throw new IllegalStateException(e);
		}
		
		var transferTrx = trxManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
	 		var accountFrom = findAccount(form.from());
			
			if(accountFrom.amount() < form.amount()) {
				throw new TransferException("No enough money from %s.".formatted(accountFrom.name()));
			}
			
			var trxId = createTransfer(form);
			createBalance(trxId, accountFrom, form.amount(), true);

			var accountTo = findAccount(form.to());
			createBalance(trxId, accountTo, form.amount(), false);
			
			updateHistory(historyId, null);
			
			trxManager.commit(transferTrx);
			
			return trxId;
		} catch (Exception e) {

			trxManager.rollback(transferTrx);
			
			var historyUpdateTrx = trxManager.getTransaction(new DefaultTransactionDefinition());
			updateHistory(historyId, e);
			trxManager.commit(historyUpdateTrx);
			
			throw new IllegalStateException(e);
		}
	}

	private void updateHistory(int historyId, Exception e) {
		
		template.update("update transfer_log set status = :status, remark = :remark where id = :id", 
				new MapSqlParameterSource()
					.addValue("id", historyId)
					.addValue("status", e == null ? "Success" : "Error")
					.addValue("remark", e == null ? "" : e.getMessage()));
	}

	private void createBalance(int trxId, AccountDto account, int amount, boolean debit) {

		var netAmount = debit ? account.amount() - amount : account.amount() + amount;
		
		// Update Account
		template.update("update account set amount = :amount where code = :code", 
				new MapSqlParameterSource()
					.addValue("amount", netAmount)
					.addValue("code", account.code()));
		
		// Create Balance History
		template.update("insert into balance_history values (:txId, :code, :amount, :last, :debit)", 
				new MapSqlParameterSource()
					.addValue("txId", trxId)
					.addValue("code", account.code())
					.addValue("amount", amount)
					.addValue("last", account.amount())
					.addValue("debit", debit));
	}

	private int createTransfer(TransferForm form) {
		
		var sql = "insert into transaction_transfer (account_from, account_to, amount, particular) values (:from, :to, :amount, :particular)";
		var generatedKey = new GeneratedKeyHolder();
		
		template.update(sql, new SimplePropertySqlParameterSource(form), generatedKey);
		
		return generatedKey.getKey().intValue();
	}

	private AccountDto findAccount(String code) {
		var sql = "select * from account where code = :code";
		return template.query(sql, Map.of("code", code), new DataClassRowMapper<>(AccountDto.class))
				.stream().findAny().orElseThrow(() -> new TransferException("Invlid account code."));
	}

	private int createHistory(TransferForm form) {
		
		var sql = "insert into transfer_log (account_from, account_to, amount) values (:from, :to, :amount)";
		var generatedKey = new GeneratedKeyHolder();
		
		template.update(sql, new MapSqlParameterSource()
				.addValue("from", form.from())
				.addValue("to", form.to())
				.addValue("amount", form.amount())
				, generatedKey);
		
		return generatedKey.getKey().intValue();
	}

}
