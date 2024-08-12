package com.jdc.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanCreationWithXMLContext {
	
	
	@Test
	void test() {
		
		try(var context = new GenericXmlApplicationContext(
				"classpath:/beans.xml")) {
			
			var service = context.getBean("service1", MyService.class);
			System.out.println(service.message());
			
			service = context.getBean("service2", MyService.class);
			System.out.println(service.message());
			
			service = context.getBean("service3", MyService.class);
			System.out.println(service.message());
		}
	}

}
