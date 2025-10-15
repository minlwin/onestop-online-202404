package com.jdc.courses.api.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.consts.CourseLevel;
import com.jdc.courses.model.entity.Classes;
import com.jdc.courses.model.entity.Classes_;
import com.jdc.courses.model.entity.Course_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public record ClassListItem(
		int id,
		int courseId,
		CourseLevel level,
		String courseName,
		LocalDate startDate,
		ClassType classType,
		int months,
		boolean deleted,
		LocalDateTime createdAt) {

	public static void select(CriteriaQuery<ClassListItem> cq, Root<Classes> root) {
		
		var course = root.join(Classes_.course, JoinType.INNER);
		
		cq.multiselect(
			root.get(Classes_.id),
			course.get(Course_.id),
			course.get(Course_.level),
			course.get(Course_.name),
			root.get(Classes_.startDate),
			root.get(Classes_.type),
			root.get(Classes_.months),
			root.get(Classes_.deleted),
			root.get(Classes_.createdAt)
		);
	}

	public static ClassListItem from(Classes entity) {
		return new ClassListItem(
				entity.getId(), 
				entity.getCourse().getId(), 
				entity.getCourse().getLevel(), 
				entity.getCourse().getName(), 
				entity.getStartDate(), 
				entity.getType(), 
				entity.getMonths(),
				entity.isDeleted(), 
				entity.getCreatedAt());
	}

}
