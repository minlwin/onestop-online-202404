package com.jdc.spring.service.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListeners {

	@EventListener
	public void handle(InteractiveAuthenticationSuccessEvent event) {
		
		var username = event.getAuthentication().getName();
		var generatedClass = event.getGeneratedBy().getSimpleName();
		
		System.out.printf("%s is authenticated by %s.%n", username, generatedClass);
	}

	@EventListener
	public void handle(AuthenticationSuccessEvent event) {
		
		var username = event.getAuthentication().getName();
		
		System.out.printf("%s is authenticated by Authentication Manager.%n", username);
	}
	
	@EventListener
	public void handle(LogoutSuccessEvent event) {
		
		var username = event.getAuthentication().getName();
		
		System.out.printf("%s is logout successfully.%n", username);
	}

	@EventListener
	public void handle(AbstractAuthenticationFailureEvent event) {
		
		var username = event.getAuthentication().getName();
		
		System.out.printf("%s is failed to authenticate.%n", username);
	}
}
