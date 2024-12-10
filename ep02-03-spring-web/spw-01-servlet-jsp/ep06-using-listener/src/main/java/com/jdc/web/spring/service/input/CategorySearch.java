package com.jdc.web.spring.service.input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.entity.Category;
import com.jdc.web.spring.entity.Category_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class CategorySearch {

	private Boolean deleted;
	private LocalDate createdFrom;
	private LocalDate createdTo;
	private String keyword;
	
	public Predicate[] where(CriteriaBuilder cb, Root<Category> root) {
		var params = new ArrayList<Predicate>();
		
		if(null != deleted) {
			params.add(cb.equal(root.get(Category_.deleted), deleted));
		}
		
		if(null != createdFrom) {
			params.add(cb.greaterThanOrEqualTo(root.get(Category_.createdAt), createdFrom.atStartOfDay()));
		}
		
		if(null != createdTo) {
			params.add(cb.lessThan(root.get(Category_.createdAt), createdTo.plusDays(1).atStartOfDay()));
		}
		
		if(StringUtils.hasLength(keyword)) {
			params.add(cb.like(cb.lower(root.get(Category_.name)), keyword.toLowerCase().concat("%")));
		}

		return params.toArray(size -> new Predicate[size]);
	}
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public void setDeleted(String parameter) {
		if(null != parameter && !parameter.isBlank()) {
			this.deleted = parameter.equals("Deleted");
		}
	}

	public void setCreatedFrom(String parameter) {
		if(null != parameter && !parameter.isBlank()) {
			this.createdFrom = LocalDate.parse(parameter, DF);
		}
	}

	public void setCreatedTo(String parameter) {
		if(null != parameter && !parameter.isBlank()) {
			this.createdTo = LocalDate.parse(parameter, DF);
		}
	}
}
