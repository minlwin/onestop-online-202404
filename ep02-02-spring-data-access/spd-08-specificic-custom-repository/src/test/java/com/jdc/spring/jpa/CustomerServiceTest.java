package com.jdc.spring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jpa.dto.input.CustomerSearch;
import com.jdc.spring.jpa.entity.Customer.Gender;
import com.jdc.spring.jpa.service.CustomerService;

@SpringBootTest
class CustomerServiceTest {

	@Autowired
	private CustomerService service;
	
	@Test
	void contextLoads() {
		
		service.search(new CustomerSearch("Thidar", "091818171", null, Gender.Female));
	}

}
