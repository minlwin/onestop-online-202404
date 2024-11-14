package com.jdc.online.spring.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest
@Sql(scripts = "/users.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class ProjectionDemo {

	@Autowired
	private CustomerRepo repo;
	
	@Test
	void test() {
		
		var result = repo.findNameByPhoneStartsWith("1111113");
		
		for(var name : result) {
			System.out.println(name.getName());
		}
	}
	
	@Test
	void test2() {
		
		var result = repo.findIdNamePhoneById(10);
		System.out.println(result.id());
		System.out.println(result.name());
		System.out.println(result.phone());
		System.out.println(result.getLongName());
	}
}
