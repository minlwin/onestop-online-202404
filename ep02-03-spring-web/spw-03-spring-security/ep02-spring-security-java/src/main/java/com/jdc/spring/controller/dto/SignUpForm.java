package com.jdc.spring.controller.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpForm {

	@NotBlank(message = "Please enter member name.")
	private String name;
	@NotBlank(message = "Please enter email for login.")
	private String email;
	@NotBlank(message = "Please enter password.")
	private String password;
	
	public Authentication getToken() {
		return UsernamePasswordAuthenticationToken.unauthenticated(email, password);
	}
}
