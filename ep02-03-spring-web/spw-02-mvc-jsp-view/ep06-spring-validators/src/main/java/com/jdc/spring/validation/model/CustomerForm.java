package com.jdc.spring.validation.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerForm {

	private String name;
	private String phone;
	private String email;
	private LocalDate dob;
	private Gender gender;
	
	public enum Gender {
		Male, Female
	}
}
