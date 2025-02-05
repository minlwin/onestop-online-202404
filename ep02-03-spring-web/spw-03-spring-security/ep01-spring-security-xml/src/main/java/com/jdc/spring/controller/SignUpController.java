package com.jdc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.controller.dto.SignUpForm;
import com.jdc.spring.exception.AppBusinessException;
import com.jdc.spring.service.AppProviderManager;
import com.jdc.spring.service.SignUpService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("signup")
public class SignUpController {
	
	@Autowired
	private SignUpService service;
	
	@Autowired
	private AppProviderManager authenticationManager;

	@GetMapping
	String signUp() {
		return "signup";
	}
	
	@PostMapping
	String signUp(
			HttpServletRequest request,
			@Validated @ModelAttribute("form") SignUpForm form, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		try {
			service.createAccount(form);
			
			// Programmatic Login
			var authentication = authenticationManager.authenticate(form.getToken());
			
			// Set Authentication to Security Context
			var securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			
			// Set Authentication to Session
			var session = request.getSession(true);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

			return "redirect:/";
			
		} catch (AppBusinessException e) {
			result.rejectValue("email", null, e.getMessage());
			return "signup";
		}		
	}
	
	@ModelAttribute("form")
	SignUpForm signUpForm() {
		return new SignUpForm();
	}
}
