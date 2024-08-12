package com.jdc.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/beans.xml")
public class BeanCreationWithJunit {
	
	@Autowired
	private MyService service;
	
	@Test
	void test() {
		System.out.println(service.message());
	}

}
