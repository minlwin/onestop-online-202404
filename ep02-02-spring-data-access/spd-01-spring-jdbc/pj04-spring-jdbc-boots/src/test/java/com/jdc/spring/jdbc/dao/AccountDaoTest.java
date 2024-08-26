package com.jdc.spring.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jdbc.dto.AccountFrom;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class AccountDaoTest {
	
	@Autowired
	private AccountDao dao;
	
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
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = {0, 4, 5})
	void test_find_by_id_not_found(int id) {
		
		var dto = dao.findById(id);
		assertNull(dto);
	}
	
}
