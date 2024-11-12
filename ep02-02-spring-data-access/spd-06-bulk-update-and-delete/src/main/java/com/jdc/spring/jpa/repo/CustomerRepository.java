package com.jdc.spring.jpa.repo;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.Customer;

public interface CustomerRepository {

	@Transactional(readOnly = true)
	Optional<Customer> findById(int id);
	
	@Transactional
	int update(int id, String name, String phone);
	
	@Transactional
	int delete(int id);
}
