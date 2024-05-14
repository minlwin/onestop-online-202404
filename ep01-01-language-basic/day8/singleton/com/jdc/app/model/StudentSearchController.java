package com.jdc.app.model;

public class StudentSearchController {

	private StudentRegistry registry;

	public StudentSearchController() {
		registry = StudentRegistry.getRegistry();
	}
	
	public void showAll() {
		// get all students from registry
		var students = registry.getAll();

		// show all students
		for(var student : students) {
			System.out.println(student);
		}
	}
}