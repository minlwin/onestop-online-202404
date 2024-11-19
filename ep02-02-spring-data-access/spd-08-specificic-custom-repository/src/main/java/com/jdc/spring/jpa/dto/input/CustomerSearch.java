package com.jdc.spring.jpa.dto.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.spring.jpa.entity.Customer;
import com.jdc.spring.jpa.entity.Customer.Gender;
import com.jdc.spring.jpa.entity.Customer_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record CustomerSearch(
		String name,
		String phone,
		String email,
		Gender gender) {

	public Predicate[] where(CriteriaBuilder cb, Root<Customer> root) {
		
		var params = new ArrayList<Predicate>();
		
		if(StringUtils.hasLength(name)) {
			params.add(cb.like(cb.lower(root.get(Customer_.name)), name.toLowerCase().concat("%")));
		}
		
		if(StringUtils.hasLength(phone)) {
			params.add(cb.like(cb.lower(root.get(Customer_.phone)), phone.toLowerCase().concat("%")));
		}

		if(StringUtils.hasLength(email)) {
			params.add(cb.like(cb.lower(root.get(Customer_.email)), email.toLowerCase().concat("%")));
		}
		
		if(null != gender) {
			params.add(cb.equal(root.get(Customer_.gender), gender));
		}

		return params.toArray(size -> new Predicate[size]);
	}

}
