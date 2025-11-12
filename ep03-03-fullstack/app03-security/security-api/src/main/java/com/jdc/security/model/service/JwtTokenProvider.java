package com.jdc.security.model.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotBlank;

@Service
public class JwtTokenProvider {

	public Authentication parseRefreshToken(@NotBlank(message = "Please enter refresh token.") String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
