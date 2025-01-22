package com.jdc.spring.validation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

	private final List<CustomerDto> list = Collections.synchronizedList(new ArrayList<>());

	public synchronized void add(CustomerForm form) {
		var dto = form.getDto(list.size() + 1);
		list.add(dto);
	}
	
	public synchronized List<CustomerDto> getAll() {
		return new ArrayList<>(list);
	}
}
