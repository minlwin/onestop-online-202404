package com.jdc.spring.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.spring.AppConfig;

public class ExplicitWiringDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			var bean1 = context.getBean("client1", MyClient.class);
			bean1.showMessage();
			
			var bean2 = context.getBean("client2", MyClient.class);
			bean2.showMessage();	
		}
		
	}
}
