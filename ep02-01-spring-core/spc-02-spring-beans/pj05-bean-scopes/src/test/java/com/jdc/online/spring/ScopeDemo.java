package com.jdc.online.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.beans.MyService;

public class ScopeDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			
			var bean1 = context.getBean("myService");
			var bean2 = context.getBean("myService", MyService.class);
			
			assertEquals(bean1, bean2);
			
			var bean3 = context.getBean("prototypeService");
			var bean4 = context.getBean("prototypeService", MyService.class);
			
			assertNotEquals(bean3, bean4);
			
		}
	}
}
