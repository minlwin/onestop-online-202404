package com.jdc.security.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.security.api.input.RefreshForm;
import com.jdc.security.api.input.SignInForm;
import com.jdc.security.api.input.SignUpForm;
import com.jdc.security.api.output.AuthResult;
import com.jdc.security.model.repo.AccountRepo;

@Service
@Transactional(readOnly = true)
public class AuthService {
	
	@Autowired
	private AccountRepo repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public AuthResult signUp(SignUpForm form) {
		var account = repo.save(form.entity(passwordEncoder));
		var authentication = UsernamePasswordAuthenticationToken.authenticated(
				account.getEmail(), 
				null, 
				List.of(new SimpleGrantedAuthority(account.getRole().name())));
		
		return getAuthResult(authentication);
	}

	public AuthResult signIn(SignInForm form) {
		var authentication = authenticationManager.authenticate(form.authentication());
		return getAuthResult(authentication);
	}

	public AuthResult refresh(RefreshForm form) {
		var authentication = tokenProvider.parseRefreshToken(form.token());
		return getAuthResult(authentication);
	}

	private AuthResult getAuthResult(Authentication authentication) {

		var account = repo.findOneByEmail(authentication.getName())
				.orElseThrow(() -> new UsernameNotFoundException(authentication.getName()));
		
		return AuthResult.from(
				account, 
				tokenProvider.generateAccessToken(authentication),
				tokenProvider.generateRefreshToken(authentication));
	}

}
