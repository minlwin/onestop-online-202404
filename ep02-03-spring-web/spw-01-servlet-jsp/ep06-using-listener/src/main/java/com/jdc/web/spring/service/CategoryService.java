package com.jdc.web.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.web.spring.entity.Category;
import com.jdc.web.spring.entity.Category_;
import com.jdc.web.spring.repo.CategoryRepo;
import com.jdc.web.spring.service.input.CategoryForm;
import com.jdc.web.spring.service.input.CategorySearch;
import com.jdc.web.spring.service.output.CategoryDetails;
import com.jdc.web.spring.service.output.CategoryInfo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;

	public List<CategoryInfo> search(CategorySearch search) {
		
		Function<CriteriaBuilder, CriteriaQuery<CategoryInfo>> queryFunc = cb -> {
			var cq = cb.createQuery(CategoryInfo.class);
			var root = cq.from(Category.class);
			
			CategoryInfo.select(cb, cq, root);
			cq.where(search.where(cb, root));
			
			cq.orderBy(cb.desc(root.get(Category_.createdAt)));
			
			return cq;
		};
		
		return repo.search(queryFunc);
	}

	public CategoryDetails findById(int id) {
		return repo.findById(id)
				.map(CategoryDetails::from)
				.orElseThrow();
	}

	@Transactional
	public int update(int id, CategoryForm form) {
		
		var entity = repo.findById(id).orElseThrow();
		entity.setName(form.getName());
		entity.setDeleted(form.isDeleted());
		
		entity.setUpdatedAt(LocalDateTime.now());
		
		return id;
	}

	@Transactional
	public int create(CategoryForm form) {
		
		var entity = new Category();
		entity.setName(form.getName());
		entity.setDeleted(form.isDeleted());
		entity.setCreatedAt(LocalDateTime.now());
		entity.setUpdatedAt(LocalDateTime.now());
		
		entity = repo.save(entity);
		
		return entity.getId();
	}

}
