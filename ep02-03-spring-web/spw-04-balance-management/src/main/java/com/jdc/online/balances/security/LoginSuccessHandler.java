package com.jdc.online.balances.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, 
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		var authority = authentication.getAuthorities().stream().map(a -> a.getAuthority()).findAny().get();
		var contextPath = request.getContextPath();
		
		response.sendRedirect("%s/%s/home".formatted(contextPath, authority.toLowerCase()));
	}

}
