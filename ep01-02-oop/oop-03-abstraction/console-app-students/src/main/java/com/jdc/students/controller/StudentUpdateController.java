package com.jdc.students.controller;

import com.jdc.students.model.StudentModel;
import com.jdc.students.model.StudentOutput;

public class StudentUpdateController extends AbstractStudentController {

	public StudentUpdateController(int id, StudentModel model) {
		super(id, "Update Student", model);
	}

	@Override
	public void doBusiness() {
		
		var id = getStudentId();
		
		if(null == model.findById(id)) {
			showMessageForStudentNotFound(id);
			return;
		}
		
		var form = getStudentInfo();
		var result = model.update(id, form);

		showResult(result);
	}

	private void showResult(StudentOutput result) {
		System.out.printf("%s has been updated successfully!%n", result.getName());
	}

}