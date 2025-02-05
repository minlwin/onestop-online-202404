package com.jdc.spring.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Service;

@Service
public class AppProviderManager extends ProviderManager{

	public AppProviderManager(
			AppAuthenticationProvider appAuthenticationProvider,
			ApplicationEventPublisher eventPublisher) {
		super(appAuthenticationProvider);
		setAuthenticationEventPublisher(new DefaultAuthenticationEventPublisher(eventPublisher));
	}
}
