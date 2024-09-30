package com.jdc.spring.introduction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class IntroductionXmlTest {

	@Autowired
	private MyService service;
	
	@Test
	void test() {
		
		service.send("Hello Introduction");
		
		if(service instanceof ExtraFunctions extra) {
			extra.logTime();
		}
	}
}
