package com.jdc.spring.service;

import java.util.function.Function;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.controller.dto.input.AccountSearch;
import com.jdc.spring.controller.dto.output.AccountDetails;
import com.jdc.spring.controller.dto.output.AccountInfo;
import com.jdc.spring.exception.AppBusinessException;
import com.jdc.spring.model.PageInfo;
import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account_;
import com.jdc.spring.model.repo.AccountRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountManagementService {

	private final AccountRepo repo;
	
	public AccountDetails findById(int id) {
		return repo.findById(id)
				.map(entity -> AccountDetails.from(entity))
				.orElseThrow(() -> new AppBusinessException("There is no entity."));
	}	
	
	public PageInfo<AccountInfo> search(AccountSearch search, int page, int size) {
		return repo.search(queryFunc(search), countFunc(search), page, size);
	}
	
	@Transactional
	@PreAuthorize("hasAuthority('Admin')")
	public void switchStatus(int id) {
		repo.findById(id).ifPresent(entity -> {
			entity.setDisabled(!entity.isDisabled());
		});
	}


	private Function<CriteriaBuilder, CriteriaQuery<AccountInfo>> queryFunc(AccountSearch search) {
		return cb -> {
			var cq = cb.createQuery(AccountInfo.class);
			var root = cq.from(Account.class);
			
			AccountInfo.select(cq, root);
			cq.where(search.where(cb, root));
			
			cq.orderBy(cb.desc(root.get(Account_.createdAt)));
			
			return cq;
		};
	}
	
	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(AccountSearch search) {
		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(Account.class);
			
			cq.select(cb.count(root));
			cq.where(search.where(cb, root));
			
			return cq;
		};
	}

}
