package com.jdc.spring.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.spring.jdbc.dto.AccountFrom;

@TestMethodOrder(value = OrderAnnotation.class)
public class AccountDaoTest {

	static GenericXmlApplicationContext context;
	
	AccountDao dao;
	
	@BeforeAll
	static void beforeAll() {
		context = new GenericXmlApplicationContext("classpath:/application.xml");
	}
	
	@AfterAll
	static void afterAll() {
		if(null != context) {
			context.close();
		}
	}
	
	@BeforeEach
	void beforeEach() {
		dao = context.getBean("dao", AccountDaoImpl.class);
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,0911112222,1",
		"Thidar,0911112223,2",
		"Nilar,0911112224,3",
	})
	void test_insert(String name, String phone, int expectedId) {
		var form = new AccountFrom(name, phone);
		var id = dao.create(form);
		assertEquals(expectedId, id);
	}
	
	@Test
	@Order(2)
	void test_select_count() {
		var count = dao.count();
		assertEquals(3, count);
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,0911112222,1",
		"Thidar,0911112223,2",
		"Nilar,0911112224,3",
	})
	void test_find_by_id(String name, String phone, int id) {
		
		var dto = dao.findById(id);
		assertEquals(name, dto.name());
		assertEquals(phone, dto.phone());
	}
	
}
