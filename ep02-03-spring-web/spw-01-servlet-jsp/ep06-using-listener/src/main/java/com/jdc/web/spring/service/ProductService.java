package com.jdc.web.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.web.spring.entity.Category_;
import com.jdc.web.spring.entity.Product;
import com.jdc.web.spring.entity.Product_;
import com.jdc.web.spring.repo.CategoryRepo;
import com.jdc.web.spring.repo.ProductRepo;
import com.jdc.web.spring.service.input.ProductForm;
import com.jdc.web.spring.service.input.ProductSearch;
import com.jdc.web.spring.service.output.ProductDetails;
import com.jdc.web.spring.service.output.ProductInfo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	public List<ProductInfo> findByCategory(int id) {
		
		Function<CriteriaBuilder, CriteriaQuery<ProductInfo>> queryFunc = cb -> {
			var cq = cb.createQuery(ProductInfo.class);
			var root = cq.from(Product.class);
			
			ProductInfo.select(cb, cq, root);
			cq.where(cb.equal(root.get(Product_.category).get(Category_.id), id));

			cq.orderBy(cb.desc(root.get(Product_.createdAt)));
			
			return cq;
		};
		
		return productRepo.search(queryFunc);
	}

	public ProductDetails findById(int id) {
		return productRepo.findById(id)
				.map(ProductDetails::from)
				.orElseThrow();
	}

	public List<ProductInfo> search(ProductSearch search) {
		Function<CriteriaBuilder, CriteriaQuery<ProductInfo>> queryFunc = cb -> {
			var cq = cb.createQuery(ProductInfo.class);
			var root = cq.from(Product.class);
			
			ProductInfo.select(cb, cq, root);
			cq.where(search.where(cb, root));
			
			cq.orderBy(cb.desc(root.get(Product_.createdAt)));
			
			return cq;
		};
		
		return productRepo.search(queryFunc);
	}

	@Transactional
	public int create(ProductForm form) {
		
		var category = categoryRepo.findById(form.getCategoryId()).orElseThrow();
		var entity = new Product();
		
		entity.setCategory(category);
		entity.setName(form.getName());
		entity.setPrice(form.getPrice());
		entity.setDeleted(form.isDeleted());
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		
		entity = productRepo.save(entity);
		return entity.getId();
	}

	@Transactional
	public int update(int id, ProductForm form) {
		
		
		var entity = productRepo.findById(id).orElseThrow();
		
		entity.setName(form.getName());
		entity.setPrice(form.getPrice());
		entity.setDeleted(form.isDeleted());
		
		entity.setUpdatedAt(LocalDateTime.now());
		
		return entity.getId();
	}
}
