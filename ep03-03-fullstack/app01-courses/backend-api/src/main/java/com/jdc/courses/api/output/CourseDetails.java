package com.jdc.courses.api.output;

import java.time.LocalDateTime;
import java.util.List;

import com.jdc.courses.model.CourseLevel;

public record CourseDetails(
		int id,
		String name,
		CourseLevel level,
		String description,
		List<ClassListItem> classes,
		boolean deleted,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {

}
