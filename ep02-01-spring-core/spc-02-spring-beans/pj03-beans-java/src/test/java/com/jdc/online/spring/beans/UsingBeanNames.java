package com.jdc.online.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.MyConfiguration;

public class UsingBeanNames {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			
			for(var name : context.getBeanFactory().getBeanDefinitionNames()) {
				System.out.println(name);
			}
		}
	}
}
