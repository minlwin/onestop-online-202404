package com.jdc.online.balances.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.controller.member.dto.LedgerForm;
import com.jdc.online.balances.controller.member.dto.LedgerListItem;
import com.jdc.online.balances.controller.member.dto.LedgerSearch;
import com.jdc.online.balances.controller.member.dto.LedgerSelectItem;
import com.jdc.online.balances.model.PageResult;
import com.jdc.online.balances.model.entity.Ledger;
import com.jdc.online.balances.model.entity.Ledger_;
import com.jdc.online.balances.model.entity.consts.BalanceType;
import com.jdc.online.balances.model.repo.LedgerRepo;
import com.jdc.online.balances.model.repo.MemberRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LedgerManagementService {
	
	private final LedgerRepo ledgerRepo;
	private final MemberRepo memberRepo;
	
	@Transactional
	public void save(LedgerForm ledgerForm) {
		
		var entity = Optional.ofNullable(ledgerForm.getId())
				.flatMap(id -> ledgerRepo.findById(id))
				.orElse(new Ledger());
		
		entity.setName(ledgerForm.getName());
		entity.setDeleted(ledgerForm.getStatus());
		entity.setType(ledgerForm.getType());
		
		if(entity.getMember() == null) {
			var username = SecurityContextHolder.getContext()
					.getAuthentication().getName();
			
			entity.setMember(memberRepo.findOneByAccountUsername(username).orElseThrow());
		}
		
		ledgerRepo.save(entity);
	}

	public LedgerForm findForEdit(Integer id) {
		return ledgerRepo.findById(id).map(LedgerForm::from)
				.orElse(new LedgerForm());
	}
	
	@PreAuthorize("authentication.name eq #username")
	public PageResult<LedgerListItem> search(String username, LedgerSearch form, int page, int size) {
		return ledgerRepo.search(queryFunc(username, form), countFunc(username, form), page, size);
	}

	private Function<CriteriaBuilder, CriteriaQuery<LedgerListItem>> queryFunc(String username, LedgerSearch form) {
		return cb -> {
			var cq = cb.createQuery(LedgerListItem.class);
			var root = cq.from(Ledger.class);
			
			LedgerListItem.select(cb, cq, root);
			cq.where(form.where(username, cb, root));
			
			cq.orderBy(
				cb.asc(root.get(Ledger_.id)) 
			);
			
			return cq;
		};
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(String username, LedgerSearch form) {
		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(Ledger.class);
			
			cq.select(cb.count(root.get(Ledger_.id)));
			cq.where(form.where(username, cb, root));
			
			return cq;
		};
	}

	public List<LedgerSelectItem> findForEntry(String username, BalanceType type) {
		// TODO Auto-generated method stub
		return null;
	}


}
