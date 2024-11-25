package com.jdc.spring.locking;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.locking.service.CustomerService;

@SpringBootTest
class LockingDemo {

	@Autowired
	private CustomerService service;
	
	@Test
	void lockDemo() {
		
//		var customer = new Customer();
//		
//		customer.setName("Aung Aung");
//		customer.setPhone("09181817171");
//		customer.setAmount(BigDecimal.valueOf(100_000));
//		
//		var id = service.create(customer);
		
		service.addBalance(1, BigDecimal.valueOf(50_000));
	}

}
