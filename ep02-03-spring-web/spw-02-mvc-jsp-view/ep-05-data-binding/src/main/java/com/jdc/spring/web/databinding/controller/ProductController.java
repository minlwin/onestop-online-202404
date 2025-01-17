package com.jdc.spring.web.databinding.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.web.databinding.controller.form.ProductForm;
import com.jdc.spring.web.databinding.model.entity.Category;
import com.jdc.spring.web.databinding.model.service.CategoryService;
import com.jdc.spring.web.databinding.model.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	@GetMapping
	String index(ModelMap model) {
		model.put("products", productService.findAll());
		return "products/list";
	}
	
	@GetMapping("edit")
	String addNew(@RequestParam(required = false) Integer id) {
		return "products/edit";
	}
	
	@PostMapping("edit")
	String save(@Validated @ModelAttribute("form") ProductForm productForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "products/edit";
		}
		
		productService.save(productForm);
		
		return "redirect:/products";
	}
	
	@ModelAttribute("form")
	ProductForm productForm(@RequestParam(required = false) Integer id) {
		
		if(null != id) {
			return productService.findForEdit(id);
		}
		
		return new ProductForm();
	}
	
	@ModelAttribute("categories")
	List<Category> categories() {
		return categoryService.findAll();
	}
}
