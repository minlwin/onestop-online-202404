package com.jdc.online.balances.controller.anonymous.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpForm {

	@NotBlank(message = "Please enter member name.")
	private String name;
	@NotBlank(message = "Please enter email for login.")
	private String username;
	@NotBlank(message = "Please enter password.")
	private String password;
}
