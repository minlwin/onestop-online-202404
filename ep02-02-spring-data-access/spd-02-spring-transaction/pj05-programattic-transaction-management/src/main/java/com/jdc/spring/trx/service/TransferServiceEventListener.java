package com.jdc.spring.trx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.jdc.spring.trx.service.event.TransferErrorEvent;
import com.jdc.spring.trx.service.event.TransferSuccessEvent;

@Component
public class TransferServiceEventListener {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void onSuccess(TransferSuccessEvent event) {
		updateHistory(event.historyId(), null);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void onError(TransferErrorEvent event) {
		updateHistory(event.historyId(), event.exception());
	}
	
	private void updateHistory(int historyId, Exception e) {
		
		template.update("update transfer_log set status = :status, remark = :remark where id = :id", 
				new MapSqlParameterSource()
					.addValue("id", historyId)
					.addValue("status", e == null ? "Success" : "Error")
					.addValue("remark", e == null ? "" : e.getMessage()));
	}

	
}
