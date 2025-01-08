package com.jdc.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.mvc.model.repo.InvoiceRepo;

@Controller
@RequestMapping("invoice")
public class InvoiceController {

	@Autowired
	private InvoiceRepo repo;
	
	@GetMapping
	String index(ModelMap model) {
		model.put("list", repo.searchAll());
		return "invoices";
	}
}
