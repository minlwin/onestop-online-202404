package com.jdc.courses.api.input;

import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.consts.CourseLevel;

public record ClassSearch(
		CourseLevel level,
		ClassType type,
		Boolean deleted,
		String keyword) {

}
