package com.jdc.online.demo;

import java.util.Arrays;

public class StudentRepository {
	
	private Student[] students = {};

	public int add(Student student) {
		// length = 0, id = 1
		student.setId(students.length + 1);
		// length = 1
		students = Arrays.copyOf(students, students.length + 1);
		// length - 1 = 0 (index = student.id - 1)
		students[students.length - 1] = student;
		return student.getId();
	}

	public Student findById(int id) {
		if(id > 0 && id <= students.length) {
			return students[id - 1];
		}
		return null;
	}

	public Student[] getAll() {
		return students;
	}

}
