package com.jdc.spring.validation.model;

import java.time.LocalDate;

import com.jdc.spring.validation.constraints.PhoneNumber;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerForm {

	@NotBlank(message = "Please enter customer name.")
	private String name;
	
	@PhoneNumber
	@NotBlank(message = "Please enter phone number.")
	private String phone;
	
	@NotBlank(message = "Please enter email.")
	@Email(message = "Please enter valid email.")
	private String email;
	
	@NotNull(message = "Please enter date of birth.")
	private LocalDate dob;
	
	@NotNull(message = "Please select gender.")
	private Gender gender;
	
	public enum Gender {
		Male, Female
	}

	public CustomerDto getDto(int id) {
		return new CustomerDto(id, name, phone, email, dob, gender);
	}
}
