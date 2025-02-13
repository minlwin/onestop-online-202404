package com.jdc.spring.controller;

import org.springframework.context.ApplicationEventPublisher;
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
import com.jdc.spring.service.listener.SignUpEvent;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("signup")
public class SignUpController {
	
	private final SignUpService service;
	private final AppProviderManager authenticationManager;
	private final ApplicationEventPublisher publisher;

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
			
			// Publish Event
			publisher.publishEvent(new SignUpEvent(form.getEmail()));
			
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
