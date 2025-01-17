package com.jdc.spring.web.databinding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.spring.web.databinding.model.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {
	
	private final CategoryService service;

	@GetMapping
	String search(ModelMap model) {
		model.put("list", service.findAll());
		return "categories";
	}
	
	@PostMapping("upload")
	String upload(@RequestPart("file") MultipartFile file) {
		
		if(null != file) {
			service.upload(file);
		}
		
		return "redirect:/categories";
	}
}
