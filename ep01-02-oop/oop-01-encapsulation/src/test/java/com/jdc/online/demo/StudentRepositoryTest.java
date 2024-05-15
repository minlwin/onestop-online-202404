package com.jdc.online.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(value = OrderAnnotation.class)
public class StudentRepositoryTest {

	static StudentRepository repo = new StudentRepository();
	
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "/students.txt")
	void test_add_student(int id, String name, String phone, String email) {
		
		var input = new Student(name, phone, email);
		int output = repo.add(input);
		
		assertEquals(id, output);
		
		input.setName(null);
	}
		
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 5)
	void test_find_all(int size) {
		var students = repo.getAll();
		assertEquals(size, students.length);
		
		Arrays.fill(students, null);
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvFileSource(resources = "/students.txt")
	void test_find_by_id(int id, String name, String phone, String email) {
		
		var output = repo.findById(id);
		
		assertEquals(name, output.getName());
		assertEquals(phone, output.getPhone());
		assertEquals(email, output.getEmail());
	}
	
}
