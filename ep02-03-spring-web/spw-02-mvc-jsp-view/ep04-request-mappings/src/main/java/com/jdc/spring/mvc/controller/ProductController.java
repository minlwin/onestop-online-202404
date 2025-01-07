package com.jdc.spring.mvc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.spring.mvc.controller.output.ProductInfo;
import com.jdc.spring.mvc.model.entity.Product;
import com.jdc.spring.mvc.model.repo.ProductRepo;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductRepo repo;

	@GetMapping
	@Transactional(readOnly = true)
	String index(ModelMap model) {
		model.put("list", repo.findAll().stream().map(ProductInfo::new).toList());
		return "products/list";
	}
	
	@Transactional
	@PostMapping("upload")
	String upload(@RequestPart MultipartFile file) {
		
		if(null != file) {
			try(var br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				
				String line = null;
				
				while(null != (line = br.readLine())) {
					var array = line.split("\t");
					
					if(check(array)) {
						var product = new Product();
						product.setName(array[0]);
						product.setCategory(array[1]);
						product.setPrice(Integer.parseInt(array[2]));
						
						repo.save(product);
					}
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/product";
	}

	private boolean check(String[] array) {
		return array.length == 3 && repo.countByNameAndCategory(array[0], array[1]) == 0L;
	}
}
