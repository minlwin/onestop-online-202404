package com.jdc.online.spring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.beans.InitializableBean;

public class InitAndDestroyDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.online.spring")) {
			
			var bean = context.getBean(InitializableBean.class);
			assertNotNull(bean);
		}
	}
}
