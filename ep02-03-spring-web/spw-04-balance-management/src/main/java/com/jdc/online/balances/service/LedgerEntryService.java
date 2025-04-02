package com.jdc.online.balances.service;

import static com.jdc.online.balances.utils.EntityOperations.safeCall;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.online.balances.controller.member.dto.LedgerEntryForm;
import com.jdc.online.balances.controller.member.dto.LedgerEntryListItem;
import com.jdc.online.balances.controller.member.dto.LedgerEntrySearch;
import com.jdc.online.balances.model.PageResult;
import com.jdc.online.balances.model.entity.LedgerEntry;
import com.jdc.online.balances.model.entity.LedgerEntry_;
import com.jdc.online.balances.model.entity.Member;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;
import com.jdc.online.balances.model.repo.LedgerEntryRepo;
import com.jdc.online.balances.model.repo.LedgerRepo;
import com.jdc.online.balances.model.repo.MemberRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LedgerEntryService {
	
	private final MemberRepo memberRepo;
	private final LedgerEntryRepo entryRepo;
	private final LedgerRepo ledgerRepo;
	private final LedgerEntryIdGenerator idGenerator;
	
	public LedgerEntryForm findForEdit(String id) {
		
		var username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		
		var member = memberRepo.findOneByAccountUsername(username)
				.get();
		
		var entryPk = LedgerEntryPk.parse(member.getId(), id);
		
		return safeCall(entryRepo.findById(entryPk).map(LedgerEntryForm::from)
				, "ledger entry", "entry id", id);
	}
	
	@Transactional
	public String save(LedgerEntryForm form) {
		
		var username = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		var member = memberRepo.findOneByAccountUsername(username).get();

		if(StringUtils.hasLength(form.getId())) {
			return update(member, form);
		}
		
		return insert(member, form);
	}	

	private String insert(Member member, LedgerEntryForm form) {
		
		var entry = new LedgerEntry();
		entry.setId(idGenerator.next(member.getId(), LocalDate.now()));
		entry.setParticular(form.getParticular());
		entry.setLedger(ledgerRepo.findById(form.getLedgerId()).get());
		entry.setIssueAt(LocalDateTime.now());
		
		var lastAmount = Optional.ofNullable(member.getActivity().getBalance()).orElse(BigDecimal.ZERO);
		var amount = form.getItems().stream()
				.map(a -> a.getUnitPrice().multiply(BigDecimal.valueOf(a.getQuantity())))
				.reduce((a, b) -> a.add(b)).orElse(BigDecimal.ZERO);
		
		entry.setLastAmount(lastAmount);
		entry.setAmount(amount);
		
		// Insert Ledger Entry
		
		// Insert Ledger Entry Items
		
		// Update Member Last Balance
		
		return null;
	}

	private String update(Member member, LedgerEntryForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<LedgerEntryListItem> search(String username, 
			BalanceType type, LedgerEntrySearch search, int page, int size) {
		return entryRepo.search(queryFunc(username, type, search), countFunc(username, type, search), page, size);
	}

	private Function<CriteriaBuilder, CriteriaQuery<LedgerEntryListItem>> queryFunc(String username, 
			BalanceType type, LedgerEntrySearch search) {
		return cb -> {
			var cq = cb.createQuery(LedgerEntryListItem.class);
			var root = cq.from(LedgerEntry.class);
			
			LedgerEntryListItem.select(cq, root);
			cq.where(search.where(cb, root, username, type));
			
			cq.orderBy(cb.desc(root.get(LedgerEntry_.issueAt)));
			
			return cq;
		};
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(String username, 
			BalanceType type, LedgerEntrySearch search) {
		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(LedgerEntry.class);
			
			cq.select(cb.count(root.get(LedgerEntry_.id)));
			cq.where(search.where(cb, root, username, type));
			
			return cq;
		};
	}

}
