package com.jdc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("access")
public class AccessHistoryController {

	@GetMapping
	String search() {
		return "access";
	}
}
