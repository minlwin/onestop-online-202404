package com.jdc.courses.api.output;

import java.time.LocalDateTime;
import java.util.List;

import com.jdc.courses.model.consts.CourseLevel;
import com.jdc.courses.model.entity.Course;

public record CourseDetails(
		int id,
		String name,
		CourseLevel level,
		String description,
		List<ClassListItem> classes,
		boolean deleted,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {
	
	public static CourseDetails from(Course entity) {
		return new CourseDetails(
				entity.getId(), 
				entity.getName(), 
				entity.getLevel(), 
				entity.getDescription(), 
				entity.getClasses().stream().map(ClassListItem::from).toList(), 
				entity.isDeleted(), 
				entity.getCreatedAt(), 
				entity.getUpdatedAt());
	}

}
