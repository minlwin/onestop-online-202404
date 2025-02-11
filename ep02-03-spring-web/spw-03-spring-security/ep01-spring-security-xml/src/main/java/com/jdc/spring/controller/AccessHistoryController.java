package com.jdc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.controller.dto.input.AccessSearch;
import com.jdc.spring.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("access")
public class AccessHistoryController {

	private final AccessHistoryService service;
	
	@GetMapping
	String search(
			AccessSearch search,
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size,
			ModelMap model) {
		
		model.put("result", service.search(search, page, size));
		
		return "access";
	}
}
