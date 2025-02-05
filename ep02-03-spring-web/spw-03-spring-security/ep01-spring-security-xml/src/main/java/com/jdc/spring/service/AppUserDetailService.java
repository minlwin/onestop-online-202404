package com.jdc.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.spring.model.repo.AccountRepo;

@Service
public class AppUserDetailService implements UserDetailsService {
	
	@Autowired
	private AccountRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return repo.findOneByEmail(username)
				.map(account -> User.withUsername(username)
						.authorities(account.getRole().name())
						.password(account.getPassword())
						.disabled(account.isDisabled())
						.build())
				.orElseThrow(() -> new UsernameNotFoundException("There is no account with email %s.".formatted(username)));
	}

}
