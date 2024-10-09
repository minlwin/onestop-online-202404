package com.jdc.spring.trx.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import com.jdc.spring.trx.exceptions.TransferException;
import com.jdc.spring.trx.service.dto.AccountDto;
import com.jdc.spring.trx.service.dto.TransferForm;

@Service
public class TransferService {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	public int transfer(TransferForm form) {
		
		var historyId = createHistory(form);
		
		var accountFrom = findAccount(form.from());
		
		if(accountFrom.amount() < form.amount()) {
			throw new TransferException("No enough money from %s.".formatted(accountFrom.name()));
		}
		
		var accountTo = findAccount(form.to());
		
		var trxId = createTransfer(form);
		
		createBalance(trxId, accountFrom, form.amount(), true);
		createBalance(trxId, accountTo, form.amount(), false);
		
		updateHistory(historyId, null);
		
		return trxId;
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
		
		var sql = "insert into tranfer (account_from, account_to, amount, tranfer) values (:from, :to, :amount, :particular)";
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
