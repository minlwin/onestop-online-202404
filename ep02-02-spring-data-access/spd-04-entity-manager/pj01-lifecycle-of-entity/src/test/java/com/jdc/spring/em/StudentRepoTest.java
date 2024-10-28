package com.jdc.spring.em;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.em.entity.Student;
import com.jdc.spring.em.repo.StudentRepo;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)
public class StudentRepoTest {
	
	@Autowired
	private StudentRepo repo;

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"User1,phone1,email1,1"
	})
	void test_create(String name, String phone, String email, int id) {
		
		var entity = new Student();
		entity.setName(name);
		entity.setPhone(phone);
		entity.setEmail(email);
		
		var result = repo.create(entity);
		assertEquals(id, result);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"User1,phone1,email1,1"
	})
	void test_find(String name, String phone, String email, int id) {
		
		var entity = repo.findById(id);
		assertNotNull(entity);
		assertEquals(name, entity.getName());
		assertEquals(phone, entity.getPhone());
		assertEquals(email, entity.getEmail());
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"User2,phone2,email2,1"
	})
	void test_update(String name, String phone, String email, int id) {
		var entity = repo.update(id, name, phone, email);
		assertNotNull(entity);
		assertEquals(name, entity.getName());
		assertEquals(phone, entity.getPhone());
		assertEquals(email, entity.getEmail());
	}
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_delete(int id) {
		repo.delete(id);
		var entity = repo.findById(id);
		assertNull(entity);
	}
	
}
