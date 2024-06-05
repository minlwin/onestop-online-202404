package com.jdc.students.model;

public interface StudentModel {

	StudentOutput[] search(String keyword);

	StudentOutput createStudent(StudentForm form);

	StudentOutput update(int id, StudentForm form);

	StudentOutput findById(int id);

}