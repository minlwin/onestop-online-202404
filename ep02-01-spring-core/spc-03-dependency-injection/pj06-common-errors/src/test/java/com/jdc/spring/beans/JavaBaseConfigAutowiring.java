package com.jdc.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.spring.MyConfiguration;

public class JavaBaseConfigAutowiring {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			
			var client = context.getBean(MyClient.class);
			client.showMessage();
		}
	}
}
