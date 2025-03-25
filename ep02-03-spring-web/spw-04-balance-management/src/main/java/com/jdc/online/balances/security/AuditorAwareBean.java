package com.jdc.online.balances.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareBean implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext())
				.map(a -> a.getAuthentication())
				.map(a -> a.getName());
	}

}
