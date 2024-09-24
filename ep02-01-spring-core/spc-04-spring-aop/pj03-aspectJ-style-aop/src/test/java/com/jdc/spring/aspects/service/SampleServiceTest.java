package com.jdc.spring.aspects.service;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.spring.ApplicationConfig;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class SampleServiceTest {

	@Autowired
	private SampleService service;
	
	@Test
	void test() {
		service.show(1, "Thidar", DayOfWeek.MONDAY);
		service.showWithLog(2, "Nilar", DayOfWeek.SUNDAY);
	}
}
