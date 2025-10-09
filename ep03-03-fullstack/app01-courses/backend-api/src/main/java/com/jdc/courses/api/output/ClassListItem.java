package com.jdc.courses.api.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.consts.CourseLevel;

public record ClassListItem(
		int id,
		int courseId,
		CourseLevel level,
		String courseName,
		LocalDate startDate,
		ClassType classType,
		boolean deleted,
		LocalDateTime createdAt) {

}
