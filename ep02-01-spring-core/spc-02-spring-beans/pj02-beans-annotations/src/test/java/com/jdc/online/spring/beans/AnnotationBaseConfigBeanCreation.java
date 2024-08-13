package com.jdc.online.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBaseConfigBeanCreation {

	@Test
	void demo() {
		
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.online.spring.beans")) {
			
			var service = context.getBean(MyService.class);
			System.out.println(service.message());
		}
		
	}
}
