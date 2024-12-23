package com.jdc.web.spring.service.input;

import static com.jdc.web.spring.utils.DateUtils.DF;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.entity.Category_;
import com.jdc.web.spring.entity.Product;
import com.jdc.web.spring.entity.Product_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class ProductSearch {

	private Boolean status;
	private LocalDate createFrom;
	private LocalDate createTo;
	private String keyword;
	private Integer categoryId;
	
	public Predicate[] where(CriteriaBuilder cb, Root<Product> root) {
		
		var params = new ArrayList<Predicate>();
		
		if(null != categoryId) {
			params.add(cb.equal(root.get(Product_.category).get(Category_.id), categoryId));
		}
		
		if(null != status) {
			params.add(cb.equal(root.get(Product_.deleted), status));
		}
		
		if(null != createFrom) {
			params.add(cb.greaterThanOrEqualTo(root.get(Product_.createdAt), createFrom.atStartOfDay()));
		}
		
		if(null != createTo) {
			params.add(cb.lessThan(root.get(Product_.createdAt), createTo.plusDays(1).atStartOfDay()));
		}
		
		if(StringUtils.hasLength(keyword)) {
			params.add(cb.or(
				cb.like(cb.lower(root.get(Product_.name)), keyword.toLowerCase().concat("%")),
				cb.like(cb.lower(root.get(Product_.category).get(Category_.name)), keyword.toLowerCase().concat("%"))
			));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}
	
	public void setCreateFrom(String parameter) {
		if(StringUtils.hasLength(parameter)) {
			createFrom = LocalDate.parse(parameter, DF);
		}
	}

	public void setCreateTo(String parameter) {
		if(StringUtils.hasLength(parameter)) {
			createTo = LocalDate.parse(parameter, DF);
		}
	}
}
