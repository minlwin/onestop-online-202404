package com.jdc.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.ioc.bean.AnnotatedBean;

public class HelloBeanTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			
			var helloBean = context.getBean(HelloBean.class);
			System.out.println(helloBean.sayHello());
			
			var annotatedBean = context.getBean(AnnotatedBean.class);
			System.out.println(annotatedBean.sayHello());
		}
	}
}
