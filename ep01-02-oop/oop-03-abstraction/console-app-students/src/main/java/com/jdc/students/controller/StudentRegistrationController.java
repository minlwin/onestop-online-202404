package com.jdc.students.controller;

import com.jdc.students.model.StudentModel;
import com.jdc.students.model.StudentOutput;

public class StudentRegistrationController extends AbstractStudentController {

	public StudentRegistrationController(int id, StudentModel model) {
		super(id, "Student Registration", model);
	}

	@Override
	public void doBusiness() {
		
		var form = getStudentInfo();
		var result = model.createStudent(form);
		showResult(result);
	}

	private void showResult(StudentOutput result) {
		System.out.printf("%s has been created at id %d.%n", result.getName(), result.getId());
	}

}