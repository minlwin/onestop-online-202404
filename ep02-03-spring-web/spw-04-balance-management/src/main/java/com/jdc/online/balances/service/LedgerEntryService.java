package com.jdc.online.balances.service;

import static com.jdc.online.balances.utils.EntityOperations.safeCall;

import java.util.function.Function;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.member.dto.LedgerEntryForm;
import com.jdc.online.balances.controller.member.dto.LedgerEntryListItem;
import com.jdc.online.balances.controller.member.dto.LedgerEntrySearch;
import com.jdc.online.balances.model.PageResult;
import com.jdc.online.balances.model.entity.LedgerEntry;
import com.jdc.online.balances.model.entity.LedgerEntry_;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;
import com.jdc.online.balances.model.repo.LedgerEntryRepo;
import com.jdc.online.balances.model.repo.MemberRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LedgerEntryService {
	
	private final LedgerEntryRepo entryRepo;
	private final MemberRepo memberRepo;
	
	public LedgerEntryForm findForEdit(String id) {
		
		var username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		
		var member = memberRepo.findOneByAccountUsername(username)
				.get();
		
		var entryPk = LedgerEntryPk.parse(member.getId(), id);
		
		return safeCall(entryRepo.findById(entryPk).map(LedgerEntryForm::from)
				, "ledger entry", "entry id", id);
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
