package com.jdc.students;

import com.jdc.console.app.ConsoleApplication;
import com.jdc.students.controller.StudentDetailsController;
import com.jdc.students.controller.StudentRegistrationController;
import com.jdc.students.controller.StudentSearchController;
import com.jdc.students.controller.StudentUpdateController;
import com.jdc.students.model.StudentModelImpl;

public class StudentManagementApp {

	public static void main(String[] args) {
		var model = new StudentModelImpl();
		var consoleApp = new ConsoleApplication(
				"Student Management System", 
				new StudentSearchController(1, model),
				new StudentDetailsController(2, model),
				new StudentUpdateController(3, model),
				new StudentRegistrationController(4, model)
		);
		consoleApp.launch();
	}

}