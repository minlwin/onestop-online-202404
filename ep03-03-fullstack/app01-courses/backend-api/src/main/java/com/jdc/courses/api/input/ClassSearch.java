package com.jdc.courses.api.input;

import com.jdc.courses.model.ClassType;
import com.jdc.courses.model.CourseLevel;

public record ClassSearch(
		CourseLevel level,
		ClassType type,
		Boolean deleted,
		String keyword) {

}
