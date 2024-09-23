package com.jdc.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/around-advice.xml")
public class AroundAdviceTest {

	@Autowired
	private AdviceArgumentsDemo demo;
	
	@Test
	void test() {
		var result = demo.getLength("Hello Around Advice");
		System.out.println(result);
//		demo.getLength(null);
	}

}
