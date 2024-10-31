package com.jdc.spring.em;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.em.repo.StudentEntityDemo;

@SpringBootTest
public class StudentEntityDemoTest {

	@Autowired
	private StudentEntityDemo demo;
	
	@Test
	void test() {
		demo.demo();
	}
}
