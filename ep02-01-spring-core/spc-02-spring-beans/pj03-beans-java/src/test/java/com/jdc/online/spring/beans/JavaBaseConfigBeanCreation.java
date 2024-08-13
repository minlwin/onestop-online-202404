package com.jdc.online.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.MyConfiguration;

public class JavaBaseConfigBeanCreation {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(
				MyConfiguration.class)) {
			
			var service = context.getBean(MyService.class);
			System.out.println(service.message());
		}
	}
}
