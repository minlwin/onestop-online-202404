package com.jdc.online.spring.data.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest
@Sql(scripts = "/users.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class PageSearchTest {

	@Autowired
	private CustomerRepo repo;
	
	@Test
	void test() {
		var result = repo.findAll(PageRequest.of(0, 10, Sort.by(Order.desc("name"))));
		System.out.println(result);
	}
}
