package com.jdc.online.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.MyConfiguration;

public class BeanNameDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			
			var bean = context.getBean("defaultService");
			
			if(bean instanceof MyService service) {
				System.out.println(service.message());
			}
		}
	}
}
