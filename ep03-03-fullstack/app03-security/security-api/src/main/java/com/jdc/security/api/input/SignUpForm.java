package com.jdc.security.api.input;

import com.jdc.security.model.entity.Account;
import com.jdc.security.model.entity.Account.Role;

import jakarta.validation.constraints.NotBlank;

public record SignUpForm(
		@NotBlank(message = "Please enter your name.")
		String name,
		@NotBlank(message = "Please enter email for login.")
		String email) {

	public Account entity() {
		var entity = new Account();
		
		entity.setName(name);
		entity.setEmail(email);
		entity.setRole(Role.Member);
		
		return entity;
	}

}
