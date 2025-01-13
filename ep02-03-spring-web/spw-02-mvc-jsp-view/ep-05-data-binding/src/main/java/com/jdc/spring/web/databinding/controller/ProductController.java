package com.jdc.spring.web.databinding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.spring.web.databinding.controller.form.ProductForm;
import com.jdc.spring.web.databinding.model.repo.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
	
	private final CategoryRepo categoryRepo;

	@GetMapping
	String index() {
		return "products/list";
	}
	
	@GetMapping("edit")
	String addNew(ModelMap model) {
		model.put("categories", categoryRepo.findAll());
		return "products/edit";
	}
	
	@PostMapping("edit")
	String save(@ModelAttribute("form") ProductForm productForm) {
		System.out.println(productForm);
		return "redirect:/products";
	}
	
	@ModelAttribute("form")
	ProductForm productForm() {
		return new ProductForm();
	}
}
