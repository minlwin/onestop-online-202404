package com.jdc.online.balances.model.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jdc.online.balances.model.BaseRepository;
import com.jdc.online.balances.model.entity.LedgerEntry;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;

public interface LedgerEntryRepo extends BaseRepository<LedgerEntry, LedgerEntryPk>{

	@Query(value = "select e from LedgerEntry e where e.id.memberId = :memberId and e.id.issueDate = :issueDate and e.id.seqNumber > :seqNumber")
	List<LedgerEntry> findRemaingEntries(long memberId, LocalDate issueDate, int seqNumber);

}
