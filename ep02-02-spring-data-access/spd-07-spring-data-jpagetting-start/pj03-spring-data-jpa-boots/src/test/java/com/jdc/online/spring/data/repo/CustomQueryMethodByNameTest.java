package com.jdc.online.spring.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest
@Sql(scripts = "/users.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class CustomQueryMethodByNameTest {

	@Autowired
	private CustomerRepo repo;
	
	@Test
	void test() {
		var result = repo.findByNameStartsWithIgnoreCase("aung");
		System.out.println(result);
	}
	
	@Test
	void test2() {
		var result = repo.findByKeyword("Aung%");
		System.out.println(result);
	}
}
