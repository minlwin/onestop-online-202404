package com.jdc.spring.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowiringDemo {

	@Test
	void demo() {
		
		try(var context = new GenericXmlApplicationContext("classpath:/application.xml")) {
			
			var client = context.getBean(MyClient.class);
			client.showMessage();
		}
	}
}
