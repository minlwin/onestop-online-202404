package com.jdc.spring.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.validation.model.CustomerForm;
import com.jdc.spring.validation.model.CustomerFormValidator;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new CustomerFormValidator());
	}
	
	@GetMapping
	String index() {
		return "customer/list";
	}
	
	
	@GetMapping("edit")
	String edit() {
		return "customer/edit";
	}
	
	@PostMapping("edit")
	String save(
			@Validated @ModelAttribute CustomerForm customerForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "customer/edit";
		}
		
		return "redirect:/customer";
	}
	
	@ModelAttribute("form")
	CustomerForm customerForm() {
		return new CustomerForm();
	}
}
