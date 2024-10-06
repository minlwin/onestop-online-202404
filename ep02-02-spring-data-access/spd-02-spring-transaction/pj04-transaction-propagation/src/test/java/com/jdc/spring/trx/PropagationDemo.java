package com.jdc.spring.trx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.jdc.spring.trx.propagation.CallerService;

@SpringBootTest
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_CLASS, scripts = "classpath:/schema.sql")
public class PropagationDemo {
	
	@Autowired
	private CallerService service;

	@Test
	void demo() {
		service.create("Start", "Base 1", null, "End");
	}
}
