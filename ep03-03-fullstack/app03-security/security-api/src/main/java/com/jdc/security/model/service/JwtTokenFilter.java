package com.jdc.security.model.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var jwtToken = request.getHeader("Authorization");
		
		if(StringUtils.hasLength(jwtToken)) {
			var authentication = tokenProvider.parseAccessToken(jwtToken);
			
			if(null != authentication) {
				SecurityContextHolder.getContext()
					.setAuthentication(authentication);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
