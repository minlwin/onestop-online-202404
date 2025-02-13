package com.jdc.spring.service.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jdc.spring.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationEventListeners {
	
	private final AccessHistoryService service;

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
		case AuthenticationFailureDisabledEvent e -> "Disabled Account";
		case AuthenticationFailureBadCredentialsEvent e -> {
			if(e.getException().getClass() == UsernameNotFoundException.class) {
                yield "Invalid Login ID";
            } else {
                yield "Invalid Password";
            }
		}
		default -> "Authentication Failure";
		};
		
		service.fails(username, message);
	}
}
