package com.jdc.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypesController {
	
	// String -> Logical View Name
	@GetMapping("/handler1")
	String handle() {
		return "view1";
	}
	
	// ModelAndView
	@GetMapping("/handler2")
	ModelAndView modelAndView() {
		return new ModelAndView("view2");
	}

	// Void
	@GetMapping("/handler3")
	void index() {
		
	}
	
}
