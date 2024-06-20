package com.jdc.online.validator.domain;

import java.util.Date;

import com.jdc.online.validator.annotations.MaxLength;
import com.jdc.online.validator.annotations.MinLength;
import com.jdc.online.validator.annotations.NotBlank;
import com.jdc.online.validator.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

	@NotBlank
	private String name;
	
	@MinLength(6)
	@MaxLength(12)
	private String phone;
	
	@NotNull
	private Date dob;
}
