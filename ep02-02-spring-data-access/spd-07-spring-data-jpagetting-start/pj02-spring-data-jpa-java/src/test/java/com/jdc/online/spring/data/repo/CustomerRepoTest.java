package com.jdc.online.spring.data.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.online.spring.JpaConfiguration;
import com.jdc.online.spring.data.entity.Customer;

@TestMethodOrder(value = OrderAnnotation.class)
@SpringJUnitConfig(classes = JpaConfiguration.class)
public class CustomerRepoTest {
	
	@Autowired
	private CustomerRepo repo;

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"1,Aung Aung,0191181818,aung@gmail.com"
	})
	void test_create(int id, String name, String phone, String email) {
			
		var customer = new Customer();
		customer.setName(name);
		customer.setPhone(phone);
		customer.setEmail(email);
		
		customer = repo.save(customer);
		
		assertEquals(id, customer.getId());
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"1,Aung Aung,0191181818,aung@gmail.com"
	})
	void test_find_by_id(int id, String name, String phone, String email) {
		
		var result = repo.findById(id);
		assertTrue(result.isPresent());
		
		var entity = result.get();
		assertEquals(name, entity.getName());
		assertEquals(phone, entity.getPhone());
		assertEquals(email, entity.getEmail());
	}
	
	
	@Order(3)
	@Test
	void test_count() {
		var count = repo.count();
		assertEquals(1, count);
	}
	
	
	@Order(4)
	@Test
	void test_find_all() {
		var list = repo.findAll();
		assertEquals(1, list.size());
	}
	
	@Order(5)
	@Test
	void test_delete() {
		repo.deleteAll();
		assertEquals(0, repo.count());
	}
}
