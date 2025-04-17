package com.jdc.online.balances.model.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jdc.online.balances.controller.member.dto.ChartAmountVo;
import com.jdc.online.balances.model.BaseRepository;
import com.jdc.online.balances.model.entity.LedgerEntry;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;

public interface LedgerEntryRepo extends BaseRepository<LedgerEntry, LedgerEntryPk>{

	@Query(value = "select e from LedgerEntry e where e.id.memberId = :memberId and e.id.issueDate = :issueDate and e.id.seqNumber > :seqNumber")
	List<LedgerEntry> findRemaingEntries(long memberId, LocalDate issueDate, int seqNumber);

	@Query(value = """
			select sum(e.amount) from LedgerEntry e 
			where e.ledger.member.account.username = :username and e.ledger.type = :type 
			and e.id.issueDate >= :from and e.id.issueDate <= :to			
			""")
	BigDecimal getSummaryData(String username, BalanceType type, LocalDate from, LocalDate to);

	@Query(value = """
			select new com.jdc.online.balances.controller.member.dto.ChartAmountVo(e.ledger.name, sum(e.amount)) 
			from LedgerEntry e where e.ledger.member.account.username = :username and e.ledger.type = :type 
			and e.id.issueDate >= :from and e.id.issueDate <= :to 
			group by e.ledger.name
			""")
	List<ChartAmountVo> getLedgerData(String username, BalanceType type, LocalDate from, LocalDate to);

	List<LedgerEntry> findByIdMemberId(long id);

}
