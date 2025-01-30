package com.jdc.spring.service;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppAuthenticationProvider extends DaoAuthenticationProvider {

	public AppAuthenticationProvider(AppUserDetailService userDetailService, 
			PasswordEncoder passwordEncoder) {
		setUserDetailsService(userDetailService);
		setPasswordEncoder(passwordEncoder);
		setHideUserNotFoundExceptions(false);
	}
}
