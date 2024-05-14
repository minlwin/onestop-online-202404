package com.jdc.app;

import java.util.Scanner;
import com.jdc.app.model.*;

public class Application {

	private Scanner scanner;
	private StudentRegistrationController registrationController;
	private StudentSearchController searchController;

	public Application() {
		scanner = new Scanner(System.in);
		registrationController = new StudentRegistrationController();
		searchController = new StudentSearchController();
	}

	public static void main(String[] args) {
		new Application().launch();
	}

	public void launch() {
		// show greeting message
		showGreetingMessage("Welcome");

		// loop
		while(true) {
			// show our operations
			showOperations();

			// get operation id from user input
			String operationId = getUserInput();

			// if user input is no operation id -> exit loop
			if(!operationId.equals("1") && !operationId.equals("2")) {
				break;
			}

			// execute operation associate with operation id
			if(operationId.equals("1")) {
				addNewStudent();
			}

			if(operationId.equals("2")) {
				showAllStudents();
			}

			System.out.println();
		}

		showGreetingMessage("Good Bye!");		
	}

	private void addNewStudent() {
		System.out.println("Add New Student Operation");
		registrationController.addNewStudent();
	}

	private void showAllStudents() {
		System.out.println("Show All Student Operation");
		searchController.showAll();
	}

	private void showGreetingMessage(String message) {
		System.out.println("=====================");
		System.out.println(message);
		System.out.println("=====================");
		System.out.println();
	}

	private void showOperations() {
		System.out.println("Operations");
		System.out.println("1. Add New Student");
		System.out.println("2. Show All");
		System.out.println();
	}

	private String getUserInput() {
		System.out.print("Operation ID : ");
		return scanner.nextLine();
	}
}