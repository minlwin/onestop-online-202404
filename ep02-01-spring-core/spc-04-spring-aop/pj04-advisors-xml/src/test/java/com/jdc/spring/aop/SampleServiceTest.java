package com.jdc.spring.aop;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.aop.service.SimpleService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class SampleServiceTest {

	@Autowired
	private SimpleService service;
	
	@Test
	void test() {
		service.show(1, "Thidar", DayOfWeek.MONDAY);
		service.showOnMethod(2, "Nilar", DayOfWeek.SUNDAY);
	}
}
