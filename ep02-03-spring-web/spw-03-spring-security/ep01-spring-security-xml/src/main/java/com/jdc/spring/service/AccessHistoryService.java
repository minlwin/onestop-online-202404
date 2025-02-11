package com.jdc.spring.service;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.controller.dto.input.AccessSearch;
import com.jdc.spring.controller.dto.output.AccessInfo;
import com.jdc.spring.model.PageInfo;
import com.jdc.spring.model.entity.AccessHistory;
import com.jdc.spring.model.entity.AccessHistory.Status;
import com.jdc.spring.model.entity.AccessHistory.Type;
import com.jdc.spring.model.entity.AccessHistory_;
import com.jdc.spring.model.repo.AccessHistoryRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional
public class AccessHistoryService {
	
	@Autowired
	private AccessHistoryRepo repo;

	public void loginSuccess(String username, Class<?> generatedBy) {
		var type = generatedBy == AbstractAuthenticationProcessingFilter.class ? AccessHistory.Type.Login : AccessHistory.Type.RememberMeLogin;
		createHistory(type, AccessHistory.Status.Success, username);
	}

	public void logoutSuccess(String username) {
		createHistory(AccessHistory.Type.Logout, AccessHistory.Status.Success, username);
	}

	public void fails(String username, String message) {
		createHistory(AccessHistory.Type.Login, AccessHistory.Status.Fails, username, message);
	}

	@PreAuthorize("authenticated")
	@Transactional(readOnly = true)
	public PageInfo<AccessInfo> search(AccessSearch search, int page, int size) {
		return repo.search(queryFunc(search), countFunc(search), page, size);
	}

	private Function<CriteriaBuilder, CriteriaQuery<AccessInfo>> queryFunc(AccessSearch search) {
		return cb -> {
			var cq = cb.createQuery(AccessInfo.class);
			var root = cq.from(AccessHistory.class);
			
			AccessInfo.select(cq, root);
			cq.where(search.where(cb, root));
			
			cq.orderBy(cb.desc(root.get(AccessHistory_.accessAt)));
			
			return cq;
		};
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(AccessSearch search) {
		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(AccessHistory.class);
			
			cq.select(cb.count(root));
			cq.where(search.where(cb, root));
			
			return cq;
		};
	}

	private void createHistory(Type type, Status status, String username) {
		createHistory(type, status, username, null);
	}

	private void createHistory(Type type, Status status, String username, String message) {
		var entity = new AccessHistory();
		entity.setAccessAt(LocalDateTime.now());
		entity.setType(type);
		entity.setStatus(status);
		entity.setUsername(username);
		entity.setRemark(message);
		
		repo.save(entity);
	}

}
