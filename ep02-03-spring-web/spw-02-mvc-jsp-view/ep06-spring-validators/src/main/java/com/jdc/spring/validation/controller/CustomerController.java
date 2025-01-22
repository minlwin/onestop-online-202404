package com.jdc.spring.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.jdc.spring.validation.model.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {
	
	private final CustomerRepository repo;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new CustomerFormValidator());
	}
	
	@GetMapping
	String index(ModelMap model) {
		model.put("customers", repo.getAll());
		return "customer/list";
	}
	
	
	@GetMapping("edit")
	String edit() {
		return "customer/edit";
	}
	
	@PostMapping("edit")
	String save(
			@Validated @ModelAttribute("form") CustomerForm customerForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "customer/edit";
		}
		
		repo.add(customerForm);
		
		return "redirect:/customer";
	}
	
	@ModelAttribute("form")
	CustomerForm customerForm() {
		return new CustomerForm();
	}
}
