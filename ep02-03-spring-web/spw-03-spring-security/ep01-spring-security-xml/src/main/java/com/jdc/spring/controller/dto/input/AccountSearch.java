package com.jdc.spring.controller.dto.input;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.spring.model.entity.Account;
import com.jdc.spring.model.entity.Account_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record AccountSearch(
		Boolean status,
		LocalDate from,
		LocalDate to,
		String keyword) {

	public Predicate[] where(CriteriaBuilder cb, Root<Account> root) {
		var params = new ArrayList<Predicate>();
		
		if(null != status) {
			params.add(cb.equal(root.get(Account_.disabled), status));
		}
		
		if(null != from) {
			params.add(cb.greaterThanOrEqualTo(root.get(Account_.createdAt), from.atStartOfDay()));
		}
		
		if(null != to) {
			params.add(cb.lessThan(root.get(Account_.createdAt), to.plusDays(1).atStartOfDay()));
		}
		
		if(StringUtils.hasLength(keyword)) {
			params.add(cb.or(
				cb.like(cb.lower(root.get(Account_.name)), keyword.toLowerCase().concat("%")),
				cb.like(root.get(Account_.email), keyword.concat("%"))
			));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}
}
