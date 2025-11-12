package com.jdc.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.security.api.input.RefreshForm;
import com.jdc.security.api.input.SignInForm;
import com.jdc.security.api.input.SignUpForm;
import com.jdc.security.api.output.AuthResult;
import com.jdc.security.model.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthApi {
	
	@Autowired
	private AuthService authService;

	@PostMapping("signup")
	AuthResult signUp(@Validated @RequestBody SignUpForm form) {
		return authService.signUp(form);
	}
	
	@PostMapping("signin")
	AuthResult signIn(@Validated @RequestBody SignInForm form) {
		return authService.signIn(form);
	}
	
	@PostMapping("refresh")
	AuthResult refresh(@Validated @RequestBody RefreshForm form) {
		return authService.refresh(form);
	}
	
	
}
