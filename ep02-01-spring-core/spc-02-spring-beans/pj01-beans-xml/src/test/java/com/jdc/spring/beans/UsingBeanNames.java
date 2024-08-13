package com.jdc.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UsingBeanNames {

	@Test
	void demo() {
		
		try(var context = new GenericXmlApplicationContext("classpath:/beans.xml")) {
			
			var beanNames = context.getBeanFactory().getBeanDefinitionNames();
			
			for(var name : beanNames) {
				System.out.println(name);
			}
		}
	}
}
