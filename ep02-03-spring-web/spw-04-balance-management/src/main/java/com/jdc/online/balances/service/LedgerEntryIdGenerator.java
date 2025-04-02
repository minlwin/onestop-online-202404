package com.jdc.online.balances.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.model.entity.LedgerEntrySeq;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntrySeqPk;
import com.jdc.online.balances.model.repo.LedgerEntrySeqRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LedgerEntryIdGenerator {
	
	private final LedgerEntrySeqRepo repo;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public LedgerEntryPk next(long memberId, LocalDate issueDate) {
		
		var seqId = new LedgerEntrySeqPk(memberId, issueDate);
		
		var entrySeq = repo.findById(seqId).orElseGet(() -> {
			var seq = new LedgerEntrySeq();
			seq.setId(seqId);
			return repo.save(seq);
		});
		
		return entrySeq.next();
	}

}
