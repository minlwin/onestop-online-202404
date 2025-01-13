package com.jdc.spring.web.databinding.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.spring.web.databinding.model.entity.Category;
import com.jdc.spring.web.databinding.model.repo.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
	
	private final CategoryRepo repo;

	@GetMapping
	String search(ModelMap model) {
		model.put("list", repo.findAll());
		return "categories";
	}
	
	@PostMapping("/upload")
	String upload(@RequestPart("file") MultipartFile file) {
		
		if(null != file) {
			try (var br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				String line = null;
				while (null != (line = br.readLine())) {
					var entity = new Category();
					entity.setName(line);
					repo.save(entity);
				}
				
			} catch (Exception e) {
                e.printStackTrace();
			}
		}
		
		return "redirect:/categories";
	}
}
