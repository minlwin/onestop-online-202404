package com.jdc.courses.api.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.courses.model.consts.CourseLevel;
import com.jdc.courses.model.entity.Course;
import com.jdc.courses.model.entity.Course_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record CourseSearch(
		CourseLevel level,
		Boolean deleted,
		String keyword) {

	public Predicate[] where(CriteriaBuilder cb, Root<Course> root) {
		
		var params = new ArrayList<>();
		
		if(null != level) {
			params.add(cb.equal(root.get(Course_.level), level));
		}
		
		if(null != deleted) {
			params.add(cb.equal(root.get(Course_.deleted), deleted));
		}
		
		if(StringUtils.hasLength(keyword)) {
			params.add(cb.like(cb.lower(root.get(Course_.name)), keyword.toLowerCase().concat("%")));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}

}
