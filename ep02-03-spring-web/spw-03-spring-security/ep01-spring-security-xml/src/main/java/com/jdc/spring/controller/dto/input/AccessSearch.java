package com.jdc.spring.controller.dto.input;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.spring.model.entity.AccessHistory;
import com.jdc.spring.model.entity.AccessHistory.Status;
import com.jdc.spring.model.entity.AccessHistory.Type;
import com.jdc.spring.model.entity.AccessHistory_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record AccessSearch(
		@RequestParam(name = "action")
		Type type,
		Status status,
		LocalDate from,
		LocalDate to,
		String keyword) {

	public Predicate[] where(CriteriaBuilder cb, Root<AccessHistory> root) {
		var params = new ArrayList<Predicate>();
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getAuthorities().stream()
				.map(a -> a.getAuthority()).toList().contains("Member")) {
			params.add(cb.equal(root.get(AccessHistory_.username), authentication.getName()));
		}
		
	    if (null != type) {
	        params.add(cb.equal(root.get(AccessHistory_.type), type));
	    }

	    if (null != status) {
	        params.add(cb.equal(root.get(AccessHistory_.status), status));
	    }

	    if (null != from) {
	        params.add(cb.greaterThanOrEqualTo(root.get(AccessHistory_.accessAt), from.atStartOfDay()));
	    }

	    if (null != to) {
	        params.add(cb.lessThanOrEqualTo(root.get(AccessHistory_.accessAt), to.atTime(LocalTime.MAX)));
	    }

	    if (null != keyword && !keyword.isBlank()) {
	        params.add(cb.or(
	            cb.like(cb.lower(root.get(AccessHistory_.username)), keyword.toLowerCase().concat("%")),
	            cb.like(cb.lower(root.get(AccessHistory_.remark)),  keyword.toLowerCase().concat("%"))
	        ));
	    }		
		return params.toArray(size -> new Predicate[size]);
	}
	
}
