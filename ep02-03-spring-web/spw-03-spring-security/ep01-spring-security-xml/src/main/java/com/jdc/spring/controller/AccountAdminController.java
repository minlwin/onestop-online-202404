package com.jdc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/account")
public class AccountAdminController {

	/**
	 * GET "/admin/account"
	 * @return
	 */
	@GetMapping
	String search() {
		return "account/list";
	}


	/**
	 * GET "/admin/account/{id}"
	 * @return
	 */
	@GetMapping("{id}")
	String findById(@PathVariable int id) {
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
