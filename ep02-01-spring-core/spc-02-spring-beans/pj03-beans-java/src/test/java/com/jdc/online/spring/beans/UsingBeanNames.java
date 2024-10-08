package com.jdc.online.spring.beans;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.online.spring.MyConfiguration;

public class UsingBeanNames {

	@Test
	void demo() {
		
		try(var context = new AnnotationConfigApplicationContext(MyConfiguration.class)) {
			
			var factory = context.getBeanFactory();
			
			for(var name : factory.getBeanDefinitionNames()) {
				System.out.println(name);
				
				var aliases = factory.getAliases(name);
				
				for(var alias : aliases) {
					System.out.printf("Alias of %s is %s%n".formatted(name, alias));
				}
			}
			
		}
	}
}
