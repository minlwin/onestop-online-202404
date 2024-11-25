package com.jdc.spring.locking.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.locking.entity.Customer;
import com.jdc.spring.locking.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Transactional
	public int create(Customer customer) {
		return repo.save(customer).getId();
	}
	
	@Transactional
	public void addBalance(int id, BigDecimal amount) {
		var customer = repo.findById(id).orElseThrow();
		customer.setAmount(customer.getAmount().add(amount));
	}
	
	@Transactional
	public void substractBalance(int id, BigDecimal amount) {
		var customer = repo.findById(id).orElseThrow();
		customer.setAmount(customer.getAmount().subtract(amount));
	}
	
}
