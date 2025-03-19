package com.jdc.online.balances.utils.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

import com.jdc.online.balances.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationEventListener {
	
	private final AccessHistoryService service;

	@EventListener
	public void handle(AuthenticationSuccessEvent event) {
		service.loginSuccess(event.getAuthentication().getName());
	}
	
	@EventListener
	public void handle(AbstractAuthenticationFailureEvent event) {
		var message = switch(event) {
		case AuthenticationFailureBadCredentialsEvent e -> "Missing Login ID or Password.";
		case AuthenticationFailureDisabledEvent e -> "Account is disabled.";
		default -> "Other Authentication Failure.";
		};
		
		service.loginError(event.getAuthentication().getName(), message);
	}
	
	@EventListener
	public void handle(LogoutSuccessEvent event) {
		service.logoutSuccess(event.getAuthentication().getName());
	}
	
}
