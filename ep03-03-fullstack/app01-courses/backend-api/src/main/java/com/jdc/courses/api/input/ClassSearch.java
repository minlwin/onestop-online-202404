package com.jdc.courses.api.input;

import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.courses.model.consts.ClassType;
import com.jdc.courses.model.consts.CourseLevel;
import com.jdc.courses.model.entity.Classes;
import com.jdc.courses.model.entity.Classes_;
import com.jdc.courses.model.entity.Course_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record ClassSearch(
		CourseLevel level,
		ClassType type,
		Boolean deleted,
		String keyword) {

	public Predicate[] where(CriteriaBuilder cb, Root<Classes> root) {
		
		var params = new ArrayList<>();
		
		if(null != level || StringUtils.hasLength(keyword)) {
			
			var course = root.join(Classes_.course, JoinType.INNER);
			
			if(null != level) {
				params.add(cb.equal(course.get(Course_.level), level));
			}
			
			
			if(StringUtils.hasLength(keyword)) {
				params.add(cb.or(
					cb.like(cb.lower(root.get(Classes_.remark)), "%%%s%%".formatted(keyword.toLowerCase())),
					cb.like(cb.lower(course.get(Course_.name)), "%%%s%%".formatted(keyword.toLowerCase())),
					cb.like(cb.lower(course.get(Course_.description)), "%%%s%%".formatted(keyword.toLowerCase()))
				));
			}
		}

		if(null != type) {
			params.add(cb.equal(root.get(Classes_.type), type));
		}
		
		if(null != deleted) {
			params.add(cb.equal(root.get(Classes_.deleted), deleted));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}

}
