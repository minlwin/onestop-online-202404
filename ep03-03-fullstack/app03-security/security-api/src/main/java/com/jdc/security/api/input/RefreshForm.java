package com.jdc.security.api.input;

import jakarta.validation.constraints.NotBlank;

public record RefreshForm(
		@NotBlank(message = "Please enter refresh token.")
		String token) {

}
