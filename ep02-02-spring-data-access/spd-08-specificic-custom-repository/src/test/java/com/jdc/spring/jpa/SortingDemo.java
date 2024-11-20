package com.jdc.spring.jpa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.spring.jpa.entity.Account;
import com.jdc.spring.jpa.entity.Customer;
import com.jdc.spring.jpa.repo.CustomerRepo;

@SpringBootTest
public class SortingDemo {

	@Autowired
	private CustomerRepo repo;
	
	@Disabled
	@Test
	void test() {
		
		var sort = Sort.by(
				Sort.Order.desc("account.activatedAt"), 
				Sort.Order.asc("name"));
		
		repo.findAll(sort);
	}
	
	@Test
	void test2() {
		var typeSort = Sort.sort(Customer.class);
		var activatedAtDesc = typeSort.by(Customer::getAccount).by(Account::getActivatedAt).descending();
		var nameAsc = typeSort.by(Customer::getName).ascending();
		
		repo.findAll(activatedAtDesc.and(nameAsc));
	}
}
