package com.jdc.demo.records;

import org.junit.jupiter.api.Test;

import com.jdc.demo.dto.Patient;
import com.jdc.demo.dto.Student;
import com.jdc.demo.dto.StudentDto;

public class RecordDemo {

	@Test
	void test_immutable() {
		
		var student = new StudentDto(1, "Aung Aung", "091818181");
		System.out.println(student);
	}
	
	@Test
	void test_record() {
		var student = new Student(1, "Aung Aung", "091818181");
		
		System.out.println(student);
		System.out.println(student.id());
		System.out.println(student.name());
		System.out.println(student.phone());
	}
	
	@Test
	void test_record_builder() {
		var patient = Patient.builder()
				.id(1)
				.name("Aung Aung")
				.bloodType("B")
				.build();
		
		System.out.println(patient);
	}
}
