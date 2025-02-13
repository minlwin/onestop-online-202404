package com.jdc.spring.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.controller.dto.SignUpForm;
import com.jdc.spring.exception.AppBusinessException;
import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account.Role;
import com.jdc.spring.model.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpService {
	
	private final AccountRepo repo;
	private final PasswordEncoder encoder;

	@Transactional
	public void createAccount(SignUpForm form) {

		// Create User
		if(repo.countByEmail(form.getEmail()) != 0L) {
			throw new AppBusinessException("Your email is already used.");
		}
		
		var member = new Account();
		member.setEmail(form.getEmail());
		member.setName(form.getName());
		member.setPassword(encoder.encode(form.getPassword()));
		member.setRole(Role.Member);
		
		repo.saveAndFlush(member);
	}

}
