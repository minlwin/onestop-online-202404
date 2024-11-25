package com.jdc.spring.locking;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.locking.service.CustomerService;

@SpringBootTest
public class InterruptedAction {

	@Autowired
	private CustomerService service;
	
	@Test
	void update() {
		
		service.substractBalance(1, BigDecimal.valueOf(30_000));
	}
}
