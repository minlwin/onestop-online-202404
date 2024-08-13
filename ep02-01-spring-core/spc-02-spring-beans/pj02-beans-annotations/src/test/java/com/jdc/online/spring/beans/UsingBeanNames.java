package com.jdc.online.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsingBeanNames {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.online")) {
			
			var names = context.getBeanFactory().getBeanDefinitionNames();
			
			for(var name : names) {
				System.out.println(name);
			}
		}
	}
}
