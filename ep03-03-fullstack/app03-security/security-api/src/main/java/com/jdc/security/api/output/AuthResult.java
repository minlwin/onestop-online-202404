package com.jdc.security.api.output;

import com.jdc.security.model.entity.Account.Role;

public record AuthResult(
		String name,
		String email,
		Role role,
		String accessToken,
		String refreshToken) {

}
