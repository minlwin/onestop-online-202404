package com.jdc.spring.trx.event;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.trx.exceptions.TransferException;
import com.jdc.spring.trx.service.dto.AccountDto;
import com.jdc.spring.trx.service.dto.TransferForm;
import com.jdc.spring.trx.service.dto.TransferLogEvent;

@Service
public class TransferServiceEvent {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private TransferLogService logService;

	@Transactional
	public int transfer(TransferForm form) {
		
		var historyId = logService.createHistory(form);
		publisher.publishEvent(new TransferLogEvent(historyId));

		var accountFrom = findAccount(form.from());
		
		if(accountFrom.amount() < form.amount()) {
			throw new TransferException("No enough money from %s.".formatted(accountFrom.name()));
		}
		
		var trxId = createTransfer(form);
		
		createBalance(trxId, accountFrom, form.amount(), true);

		var accountTo = findAccount(form.to());
		createBalance(trxId, accountTo, form.amount(), false);
		
		return trxId;
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


}
