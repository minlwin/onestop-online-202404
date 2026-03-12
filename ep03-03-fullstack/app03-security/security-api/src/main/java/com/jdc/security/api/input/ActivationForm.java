package com.jdc.security.api.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActivationForm(
		@NotNull(message = "Please enter account id.")
		Integer userId,
		@NotBlank(message = "Please enter otp code.")
		String otpCode,
		@NotBlank(message = "Please enter new password.")
		String password) {

}
