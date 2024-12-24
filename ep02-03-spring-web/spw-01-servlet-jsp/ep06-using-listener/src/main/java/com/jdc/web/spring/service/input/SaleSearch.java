package com.jdc.web.spring.service.input;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.web.spring.entity.Sale;
import com.jdc.web.spring.entity.Sale_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class SaleSearch {

	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String customer;
	
	public Predicate[] where(CriteriaBuilder cb, Root<Sale> root) {
		var params = new ArrayList<Predicate>();
		
		if(null != dateFrom) {
			params.add(cb.greaterThanOrEqualTo(root.get(Sale_.saleAt), dateFrom.atStartOfDay()));
		}
		
		if(null != dateTo) {
			params.add(cb.lessThan(root.get(Sale_.saleAt), dateTo.plusDays(1).atStartOfDay()));
		}
		
		if(StringUtils.hasLength(customer)) {
			params.add(cb.like(cb.lower(root.get(Sale_.customer)), customer.toLowerCase().concat("%")));
		}
		
		
		return params.toArray(size -> new Predicate[size]);
	}
}
