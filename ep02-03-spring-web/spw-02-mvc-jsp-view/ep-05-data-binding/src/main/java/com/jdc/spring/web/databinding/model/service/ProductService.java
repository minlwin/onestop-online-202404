package com.jdc.spring.web.databinding.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.web.databinding.controller.form.ProductForm;
import com.jdc.spring.web.databinding.model.entity.Product;
import com.jdc.spring.web.databinding.model.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepo productRepo;
	
	@Transactional
	public void save(ProductForm form) {
		var entity = new Product();
		
		entity.setId(form.getId());
		entity.setCategory(form.getCategory());
		entity.setName(form.getName());
		entity.setPrice(form.getPrice());
		
		productRepo.save(entity);
	}
	
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Transactional(readOnly = true)
	public ProductForm findForEdit(Integer id) {
		return productRepo.findById(id)
				.map(a -> {
					var form = new ProductForm();
					form.setId(a.getId());
					form.setCategory(a.getCategory());
					form.setName(a.getName());
					form.setPrice(a.getPrice());
					return form;
				}).orElse(new ProductForm());
	}

}
