package com.jdc.security.model.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.security.model.entity.Account;
import com.jdc.security.model.repo.AccountRepo;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepo.findOneByEmail(username).map(account -> User.builder()
				.username(username)
				.password(account.getPassword())
				.authorities(account.getRole().name())
				.disabled(isDisabled(account))
				.build())
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}

	private boolean isDisabled(Account account) {
		
		if(null == account.getActivatedAt()) {
			return true;
		}
		
		return LocalDateTime.now().isBefore(account.getActivatedAt());
	}

}
