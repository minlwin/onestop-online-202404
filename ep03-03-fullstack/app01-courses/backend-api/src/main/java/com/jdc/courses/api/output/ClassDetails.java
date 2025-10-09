package com.jdc.courses.api.output;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.consts.CourseLevel;

public record ClassDetails(
		int id,
		int courseId,
		CourseLevel level,
		String courseName,
		LocalDate startDate,
		ClassType classType,
		String remark,
		List<Schedule> schedules,
		boolean deleted,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {

}
