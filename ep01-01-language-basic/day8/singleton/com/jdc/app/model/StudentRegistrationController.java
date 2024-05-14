package com.jdc.app.model;

import java.util.Scanner;

public class StudentRegistrationController {

	private Scanner scanner;
	private StudentRegistry registry;

	public StudentRegistrationController() {
		scanner = new Scanner(System.in);
		registry = StudentRegistry.getRegistry();
	}

	public void addNewStudent() {
		// Show message to enter student name
		System.out.print("Please enter student name : ");

		// get user input
		String name = scanner.nextLine();

		// add to student registory
		registry.addNew(name);
	}	
}