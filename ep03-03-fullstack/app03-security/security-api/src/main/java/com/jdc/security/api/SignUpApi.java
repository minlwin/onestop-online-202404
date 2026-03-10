package com.jdc.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.security.api.input.SignUpForm;
import com.jdc.security.api.output.SignUpResult;
import com.jdc.security.model.service.AccountService;

@RestController
@RequestMapping("auth/signup")
public class SignUpApi {
	
	@Autowired
	private AccountService service;

	@PostMapping
	SignUpResult signUp(@Validated @RequestBody SignUpForm form) {
		return service.signUp(form);
	}
}
