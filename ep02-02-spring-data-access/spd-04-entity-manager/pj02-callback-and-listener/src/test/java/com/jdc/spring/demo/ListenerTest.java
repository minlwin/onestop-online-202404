package com.jdc.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.demo.entity.Address;
import com.jdc.spring.demo.entity.Student;
import com.jdc.spring.demo.repo.StudentRepo;

@SpringBootTest
public class ListenerTest {

	@Autowired
	private StudentRepo repo;
	
	@Test
	void test() {
		
		var student = new Student();
		var address = new Address();
		
		address.setBuilding("No 120B/1F");
		address.setStreet("Yadanar Myaing Street");
		address.setQuarter("Kamayut 1");
		address.setTownship("Kamayut");
		
		student.setAddress(address);
		student.setName("Aung Aung");
		
		repo.create(student);
		
		student.setName("Aung Aung Oo");
		address.setQuarter("Kamayut 1 Quarter");
		
		repo.update(student);
		
		var list = repo.findAll();
		
		assertNotNull(list);
		assertEquals(student, list.get(0));
		
	}
}
