package com.jdc.courses.api.output;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.consts.CourseLevel;
import com.jdc.courses.model.entity.Classes;

public record ClassDetails(
		int id,
		int courseId,
		CourseLevel level,
		String courseName,
		LocalDate startDate,
		ClassType classType,
		int months,
		String remark,
		List<Schedule> schedules,
		boolean deleted,
		LocalDateTime createdAt,
		LocalDateTime updatedAt) {

	public static ClassDetails from(Classes entity, Function<String, List<Schedule>> mapper) {
		return new ClassDetails(
				entity.getId(), 
				entity.getCourse().getId(), 
				entity.getCourse().getLevel(), 
				entity.getCourse().getName(), 
				entity.getStartDate(), 
				entity.getType(), 
				entity.getMonths(),
				entity.getRemark(), 
				mapper.apply(entity.getSchedules()), 
				entity.isDeleted(), 
				entity.getCreatedAt(), 
				entity.getUpdatedAt());
	}

}
