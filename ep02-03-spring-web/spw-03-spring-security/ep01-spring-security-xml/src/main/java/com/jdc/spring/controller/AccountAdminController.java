package com.jdc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.controller.dto.input.AccountSearch;
import com.jdc.spring.service.AccountManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/account")
public class AccountAdminController {
	
	private final AccountManagementService service;

	/**
	 * GET "/admin/account"
	 * @return
	 */
	@GetMapping
	String search(
			AccountSearch search, 
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size,
			ModelMap model) {
		
		model.put("result", service.search(search, page, size));
		
		return "account/list";
	}


	/**
	 * GET "/admin/account/{id}"
	 * @return
	 */
	@GetMapping("{id}")
	String findById(@PathVariable int id, ModelMap model) {
		
		model.put("result", service.findById(id));
		
		return "account/details";
	}
	
	/**
	 * POST "/admin/account/{id}/status"
	 * @return
	 */
	@PostMapping("{id}/status")
	String changeStatus(@PathVariable int id) {
		return "redirect:/admin/account/{id}";
	}
}
