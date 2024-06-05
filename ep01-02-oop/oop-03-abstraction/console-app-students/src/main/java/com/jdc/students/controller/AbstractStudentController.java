package com.jdc.students.controller;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.students.model.StudentForm;
import com.jdc.students.model.StudentModel;

public abstract class AbstractStudentController extends AbstractFeature {

	protected StudentModel model;

	public AbstractStudentController(int id, String name, StudentModel model) {
		super(id, name);
		this.model = model;
	}

	protected int getStudentId() {
		return UserInputs.readInt("Student ID : ");
	}

	protected StudentForm getStudentInfo() {
		
		var form = new StudentForm();
		
		form.setName(getStudentName());
		form.setPhone(getPhone());
		form.setEmail(getEmail());
		form.setAddress(getAddress());
		
		return form;
	}

	private String getStudentName() {
		return UserInputs.readString("Student Name : ");
	}

	private String getPhone() {
		return UserInputs.readString("Phone Number : ");
	}

	private String getEmail() {
		return UserInputs.readString("Email : ");
	}

	private String getAddress() {
		return UserInputs.readString("Address : ");
	}

}