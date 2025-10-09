package com.jdc.courses.api.input;

import com.jdc.courses.model.consts.CourseLevel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseForm(
		@NotBlank(message = "Please enter course name.")
		String name,
		@NotNull(message = "Please select course level.")
		CourseLevel level,
		@NotBlank(message = "Please enter course descrption.")
		String description) {

}
