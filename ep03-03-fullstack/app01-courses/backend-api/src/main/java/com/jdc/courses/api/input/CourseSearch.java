package com.jdc.courses.api.input;

import com.jdc.courses.model.CourseLevel;

public record CourseSearch(
		CourseLevel level,
		Boolean deleted,
		String keyword) {

}
