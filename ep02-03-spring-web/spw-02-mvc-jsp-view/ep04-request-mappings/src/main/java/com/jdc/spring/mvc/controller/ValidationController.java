package com.jdc.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("validation")
public class ValidationController {

	@GetMapping
	public String index() {
		return "validation";
	}
	
	@PostMapping
	public String save() {
		return "redirect:/validation";
	}
}
