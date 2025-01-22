package com.jdc.spring.validation.model;

import java.time.LocalDate;

import com.jdc.spring.validation.model.CustomerForm.Gender;

public record CustomerDto(
		int id,
		String name,
		String phone,
		String email,
		LocalDate dob,
		Gender gender) {

}
