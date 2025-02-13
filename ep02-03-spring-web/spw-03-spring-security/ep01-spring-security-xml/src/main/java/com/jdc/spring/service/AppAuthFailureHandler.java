package com.jdc.spring.service;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppAuthFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		var message = switch(exception) {
		case UsernameNotFoundException e -> "Please check login id.";
		case BadCredentialsException e -> "Please check password.";
		case DisabledException e -> "Your account is disabled.";
		default -> "Authentication Error.";
		};
		
		response.sendRedirect(request.getContextPath().concat("/authenticate?error=%s".formatted(message)));
	}

}
