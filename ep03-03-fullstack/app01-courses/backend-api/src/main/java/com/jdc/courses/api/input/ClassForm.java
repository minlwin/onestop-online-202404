package com.jdc.courses.api.input;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.courses.api.output.Schedule;
import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.entity.Classes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ClassForm(
		@NotNull(message = "Please select course.")
		Integer courseId,
		@NotNull(message = "Please enter start date.")
		LocalDate startDate,
		@NotNull(message = "Please select class type.")
		ClassType classType,
		String remark,
		@NotEmpty(message = "Please enter schedule.")
		List<@Valid Schedule> schedules) {

	public Classes entity() {
		
		var entity = new Classes();
		
		entity.setStartDate(startDate);
		entity.setType(classType);
		entity.setRemark(remark);
		entity.setCreatedAt(LocalDateTime.now());
		
		return entity;
	}

}
