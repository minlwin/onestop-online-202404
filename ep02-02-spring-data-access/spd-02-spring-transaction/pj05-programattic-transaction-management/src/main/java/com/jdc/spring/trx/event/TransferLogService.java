package com.jdc.spring.trx.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.jdc.spring.trx.service.dto.TransferForm;
import com.jdc.spring.trx.service.dto.TransferLogEvent;

@Service
public class TransferLogService {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int createHistory(TransferForm form) {
		
		var sql = "insert into transfer_log (account_from, account_to, amount) values (:from, :to, :amount)";
		var generatedKey = new GeneratedKeyHolder();
		
		template.update(sql, new MapSqlParameterSource()
				.addValue("from", form.from())
				.addValue("to", form.to())
				.addValue("amount", form.amount())
				, generatedKey);
		
		return generatedKey.getKey().intValue();
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void updateSuccess(TransferLogEvent event) {
		
		template.update("update transfer_log set status = :status where id = :id", 
				new MapSqlParameterSource()
					.addValue("id", event.historyId())
					.addValue("status", "Success"));
	}

//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
//	public void updateError(TransferLogEvent event, Exception e) {
//		
//		template.update("update transfer_log set status = :status, remark = :remark where id = :id", 
//				new MapSqlParameterSource()
//					.addValue("id", event.historyId())
//					.addValue("status", e == null ? "Success" : "Error")
//					.addValue("remark", e == null ? "" : e.getMessage()));
//	}

}
