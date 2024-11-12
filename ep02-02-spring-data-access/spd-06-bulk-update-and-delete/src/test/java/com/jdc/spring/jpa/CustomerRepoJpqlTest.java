package com.jdc.spring.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.jdc.spring.jpa.repo.jpql.CustomerRepoJpql;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
@Sql(scripts = "/customers.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class CustomerRepoJpqlTest {

	@Autowired
	private CustomerRepoJpql repo;
	
	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
		"1	Aung Aung	0911112222	aung@gmail.com",
		"2	Maung Maung	0911112223	maung@gmail.com",
		"3	Thidar	0911112224	thidar@gmail.com",
		"4	Nilar	0911112225	nilar@gmail.com"
	}, delimiter = '\t')
	void test_find_by_id(int id, String name, String phone, String email) {
		var customer = repo.findById(id);
		assertTrue(customer.isPresent());
		
		customer.ifPresent(entity -> {
			assertEquals(name, entity.getName());
			assertEquals(phone, entity.getPhone());
			assertEquals(email, entity.getEmail());
		});
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource(value = {
		"1	Aung Aung Oo	0911112223",
		"2	Maung Maung Naing	0911112224",
		"3	Thidar Aung	0911112225",
		"4	Nilar Oo	0911112226"
	}, delimiterString = "\t")
	void test_update(int id, String name, String phone) {
		
		var result = repo.update(id, name, phone);
		assertEquals(result, 1);
	}
	
	@Disabled
	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void test_delete(int id) {
		var result = repo.delete(id);
		assertEquals(result, 1);
	}	
}
