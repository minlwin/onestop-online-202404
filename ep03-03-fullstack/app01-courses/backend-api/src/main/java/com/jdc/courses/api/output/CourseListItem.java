package com.jdc.courses.api.output;

import java.time.LocalDateTime;

import com.jdc.courses.model.CourseLevel;

public record CourseListItem(
		int id,
		String name,
		CourseLevel level,
		String description,
		boolean deleted,
		LocalDateTime createdAt) {

}
