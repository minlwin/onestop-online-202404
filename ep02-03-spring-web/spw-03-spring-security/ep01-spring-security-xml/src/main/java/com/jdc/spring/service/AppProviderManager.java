package com.jdc.spring.service;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Service;

@Service
public class AppProviderManager extends ProviderManager{

	public AppProviderManager(AppAuthenticationProvider appAuthenticationProvider) {
		super(appAuthenticationProvider);
	}
}
