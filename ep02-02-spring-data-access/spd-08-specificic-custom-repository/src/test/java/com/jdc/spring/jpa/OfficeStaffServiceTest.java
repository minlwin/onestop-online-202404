package com.jdc.spring.jpa;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jpa.entity.OfficeStaff.Position;
import com.jdc.spring.jpa.service.OfficeStaffService;

@SpringBootTest
public class OfficeStaffServiceTest {

	@Autowired
	private OfficeStaffService service;
	
	@Test
	void loadTest() {
		service.searchCount(Position.Employee, LocalDate.now());
	}
}
