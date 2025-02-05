package com.jdc.spring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.model.entity.AccessHistory;
import com.jdc.spring.model.entity.AccessHistory.Status;
import com.jdc.spring.model.entity.AccessHistory.Type;
import com.jdc.spring.model.repo.AccessHistoryRepo;

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
