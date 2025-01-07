package com.jdc.spring.mvc.controller.output;

import java.time.LocalDate;

import com.jdc.spring.mvc.model.entity.Person;
import com.jdc.spring.mvc.model.entity.Person.Gender;

public record PersonInfo(
		int id,
		String name,
		String phone,
		LocalDate dob,
		Gender gender) {

	public PersonInfo(Person entity) {
		this(entity.getId(), entity.getName(), entity.getPhone(), entity.getDob(), entity.getGender());
	}
}
