package com.jdc.spring.mvc.controller.input;

import java.time.LocalDate;

import com.jdc.spring.mvc.model.entity.Person;
import com.jdc.spring.mvc.model.entity.Person.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonForm {

	private Integer id;
	
	@NotBlank(message = "Please enter name.")
	private String name;
	@NotNull(message = "Please select date of birth.")
	private LocalDate dob;
	@NotNull(message = "Please select gender.")
	private Gender gender;
	@NotBlank(message = "Please enter phone number.")
	private String phone;
	
	public Person entity() {
		var entity = new Person();
		entity.setId(id);
		entity.setName(name);
		entity.setPhone(phone);
		entity.setGender(gender);
		entity.setDob(dob);
		return entity;
	}
	
	public static PersonForm from(Person entity) {
		var form = new PersonForm();
		form.setId(entity.getId());
		form.setName(entity.getName());
		form.setDob(entity.getDob());
		form.setGender(entity.getGender());
		form.setPhone(entity.getPhone());
		return form;
	}
}
