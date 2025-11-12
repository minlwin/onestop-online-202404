package com.jdc.security.api.input;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.security.model.entity.Account;
import com.jdc.security.model.entity.Account.Role;

import jakarta.validation.constraints.NotBlank;

public record SignUpForm(
		@NotBlank(message = "Please enter your name.")
		String name,
		@NotBlank(message = "Please enter email for login.")
		String email,
		@NotBlank(message = "Please enter password.")
		String password) {

	public Account entity(PasswordEncoder encoder) {
		var entity = new Account();
		
		entity.setName(name);
		entity.setEmail(email);
		entity.setRole(Role.Member);
		entity.setPassword(encoder.encode(password));
		
		return entity;
	}

}
