package com.jdc.students.controller;

import com.jdc.console.app.UserInputs;
import com.jdc.students.model.StudentModel;
import com.jdc.students.model.StudentOutput;

public class StudentSearchController extends AbstractStudentController {

	public StudentSearchController(int id, StudentModel model) {
		super(id, "Search Student", model);
	}

	@Override
	public void doBusiness() {

		var keyword = getKeyword();
		var result = model.search(keyword);
		
		if(result.length > 0) {
			showResult(result);
		} else {
			System.out.println("There is no result!");
		}
	}

	private String getKeyword() {
		return UserInputs.readString("Search Keyword : ");
	}

	private void showResult(StudentOutput[] result) {
		
		System.out.print("ID");
		System.out.print("Name");
		System.out.print("Phone");
		System.out.print("Email");
		System.out.println("Address");
		
		System.out.println("-");
		
		for(var student : result) {
			System.out.printf("%s", student.getId());
			System.out.printf("%s", student.getName());
			System.out.printf("%s", student.getPhone());
			System.out.printf("%s", student.getEmail());
			System.out.printf("%s%n%n", student.getAddress());
		}
	}

}