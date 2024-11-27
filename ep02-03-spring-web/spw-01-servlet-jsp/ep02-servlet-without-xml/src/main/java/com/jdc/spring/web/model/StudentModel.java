package com.jdc.spring.web.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StudentModel {
	
	private Map<Integer, Student> map;
	
	private static StudentModel instance;
	private static int studentId;
	
	public static StudentModel getInstance() {
		
		if(null == instance) {
			instance = new StudentModel();
		}
		
		return instance;
	}

	private StudentModel() {
		map = Collections.synchronizedMap(new HashMap<>());
	}
	
	public int addStudent(String name, String phone, String email) {
		studentId ++;
		var student = new Student(studentId, name, phone, email);
		map.put(studentId, student);	
		return studentId;
	}
	
	public Student findById(int id) {
		return map.get(id);
	}
}
