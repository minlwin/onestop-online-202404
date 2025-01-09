package com.jdc.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("exception")
public class ExceptionHandlingController {

	@GetMapping
	String index() {
		return "exception-demo";
	}
	
	@PostMapping
	String parse(@RequestParam String data, ModelMap model) {
		
		var intValue = Integer.parseInt(data);
		model.put("intValue", intValue);
		
		return "exception-demo";
	}
}
