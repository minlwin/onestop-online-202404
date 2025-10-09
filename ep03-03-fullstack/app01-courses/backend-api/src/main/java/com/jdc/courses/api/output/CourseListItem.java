package com.jdc.courses.api.output;

import java.time.LocalDateTime;

import com.jdc.courses.model.consts.CourseLevel;
import com.jdc.courses.model.entity.Course;
import com.jdc.courses.model.entity.Course_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record CourseListItem(
		int id,
		String name,
		CourseLevel level,
		String description,
		boolean deleted,
		LocalDateTime createdAt) {

	public static void select(CriteriaQuery<CourseListItem> cq, Root<Course> root) {
		cq.multiselect(
			root.get(Course_.id),
			root.get(Course_.name),
			root.get(Course_.level),
			root.get(Course_.description),
			root.get(Course_.deleted),
			root.get(Course_.createdAt)
		);
	}

}
