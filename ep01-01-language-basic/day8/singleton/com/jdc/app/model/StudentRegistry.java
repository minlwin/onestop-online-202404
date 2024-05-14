package com.jdc.app.model;

import java.util.*;

class StudentRegistry {

	private List<String> students;

	private static StudentRegistry registry;

	public static StudentRegistry getRegistry() {

		if(null == registry) {
			registry = new StudentRegistry();
		}

		return registry;
	}

	private StudentRegistry() {
		students = new ArrayList<>();
	}
	
	void addNew(String name) {
		students.add(name);
	}

	List<String> getAll() {
		return students;
	}
}