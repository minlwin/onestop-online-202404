package com.jdc.spring.introduction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.AppConfig;

@SpringJUnitConfig(value = AppConfig.class)
public class IntroductionJavaTest {

	@Autowired
	private MyService service;
	
	@Test
	void test() {
		
		for (int i = 0; i < 5; i++) {
			service.send("Hello Introduction %s".formatted(i + 1));
			
			if(service instanceof ExtraFunctions extra) {
				extra.logTime();
			}
		}
	}

}
