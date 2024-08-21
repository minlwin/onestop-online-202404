package com.jdc.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDependencyDemo {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext("com.jdc.spring.circular")) {
			
		}
	}
}
