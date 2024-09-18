package com.jdc.spring.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/advice-arguments.xml")
public class AdviceArgumentsTest {
	
	@Autowired
	private AdviceArgumentsDemo demo;
	
	@Test
	public void test() {
		demo.getLength("Hello World");
//		demo.getLength(null);
	}

}
