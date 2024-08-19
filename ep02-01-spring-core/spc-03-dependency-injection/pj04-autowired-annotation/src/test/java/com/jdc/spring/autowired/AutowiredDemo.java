package com.jdc.spring.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.spring")) {
			
			var bean = context.getBean(MyClient.class);
			bean.showMessage();
		}
	}
}
