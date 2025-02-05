package com.jdc.spring.service.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

import com.jdc.spring.service.AccessHistoryService;

@Component
public class AuthenticationEventListeners {
	
	@Autowired
	private AccessHistoryService service;

	@EventListener
	public void handle(InteractiveAuthenticationSuccessEvent event) {
		var username = event.getAuthentication().getName();
		service.loginSuccess(username, event.getGeneratedBy());
	}

	@EventListener
	public void handle(LogoutSuccessEvent event) {
		
		var username = event.getAuthentication().getName();
		service.logoutSuccess(username);
	}

	@EventListener
	public void handle(AbstractAuthenticationFailureEvent event) {
		
		var username = event.getAuthentication().getName();
		var message = switch (event) {
		case AuthenticationFailureBadCredentialsEvent e -> "Missing username or password.";
		default -> "Authentication Failure";
		};
		
		service.fails(username, message);
	}
}
