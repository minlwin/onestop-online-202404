package com.jdc.students.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(value = OrderAnnotation.class)
public class StudentModelTest {

	private static StudentModel model = new StudentModelImpl();
	
	@Order(1)
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void test_find_by_id_initial_state(int id) {
		
		var result = model.findById(id);
		assertNull(result);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvFileSource(delimiterString = "\t", resources = "/student-update.txt")
	void test_find_update_initial_state(int id, String name, String phone, String email, String address) {
		var result = model.update(id, new StudentForm(name, phone, email, address));
		assertNull(result);
	}

	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Aung,0",
		"gmail,0",
		"Yangon,0",
		"Mandalay,0",
		"Bankok,0"
	})
	void test_search_initial_state(String keyword, int size) {
		
		var result = model.search(keyword);
		assertEquals(size, result.length);
	}

	@Order(4)
	@ParameterizedTest
	@CsvFileSource(delimiterString = "\t", resources = "/student-creation.txt")
	void test_create(int id, String name, String phone, String email, String address) {
		// Prepare Input
		var form = new StudentForm(name, phone, email, address);
		
		var result = model.createStudent(form);
		
		assertNotNull(result);
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(phone, result.getPhone());
		assertEquals(email, result.getEmail());
		assertEquals(address, result.getAddress());
	}
	
	@Order(5)
	@ParameterizedTest
	@CsvFileSource(delimiterString = "\t", resources = "/student-creation.txt")
	void test_find_by_id_found(int id, String name, String phone, String email, String address) {
		
		var result = model.findById(id);
		
		assertNotNull(result);
				
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(phone, result.getPhone());
		assertEquals(email, result.getEmail());
		assertEquals(address, result.getAddress());
	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = {0, 6, 7})
	void test_find_by_id_not_found(int id) {
		
		var result = model.findById(id);
		
		assertNull(result);
	}
	
	@Order(7)
	@ParameterizedTest
	@CsvSource({
		"Aung,2",
		"gmail,5",
		"Yangon,2",
		"Mandalay,1",
		"Bankok,0"
	})
	void test_search(String keyword, int size) {
		
		var result = model.search(keyword);
		assertEquals(size, result.length);
	}
	
	
	@Order(8)
	@ParameterizedTest
	@CsvFileSource(delimiterString = "\t", resources = "/student-update.txt")
	void test_update_success(int id, String name, String phone, String email, String address) {
		
		var form = new StudentForm(name, phone, email, address);
		
		var result = model.update(id, form);
		
		assertNotNull(result);
		
		assertEquals(id, result.getId());
		assertEquals(name, result.getName());
		assertEquals(phone, result.getPhone());
		assertEquals(email, result.getEmail());
		assertEquals(address, result.getAddress());		
	}
	
	@Order(9)
	@ParameterizedTest
	@CsvSource({
		"6,Nyi Nyi,019181811,nyinyi@gmail.com,Mandalay"
	})
	void test_update_no_data(int id, String name, String phone, String email, String address) {
		
		var form = new StudentForm(name, phone, email, address);
		
		var result = model.update(id, form);
		
		assertNull(result);
	}

}
