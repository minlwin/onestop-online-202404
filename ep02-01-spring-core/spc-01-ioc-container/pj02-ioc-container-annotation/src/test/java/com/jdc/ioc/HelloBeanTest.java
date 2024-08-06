package com.jdc.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloBeanTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.ioc")) {
			
			var bean = context.getBean(HelloBean.class);
			System.out.println(bean.sayHello());
		}
	}
}
