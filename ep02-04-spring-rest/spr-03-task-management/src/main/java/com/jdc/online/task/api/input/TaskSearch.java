package com.jdc.online.task.api.input;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.jdc.online.task.model.entity.Project_;
import com.jdc.online.task.model.entity.Tasks;
import com.jdc.online.task.model.entity.Tasks_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public record TaskSearch(
		Integer projectId,
		LocalDate dueDateFrom,
		LocalDate dueDateTo,
		LocalDate startFrom,
		LocalDate startTo,
		LocalDate endFrom,
		LocalDate endTo,
		String keyword) {

	public Predicate[] where(CriteriaBuilder cb, Root<Tasks> root) {
		
		var params = new ArrayList<Predicate>();
		
		if(null != projectId) {
			params.add(cb.equal(root.get(Tasks_.project).get(Project_.id), projectId));
		}
		
		if(null != dueDateFrom) {
			params.add(cb.greaterThanOrEqualTo(root.get(Tasks_.dueDate), dueDateFrom));
		}
		
		if(null != dueDateTo) {
			params.add(cb.lessThanOrEqualTo(root.get(Tasks_.dueDate), dueDateTo));
		}

		if(null != startFrom) {
			params.add(cb.greaterThanOrEqualTo(root.get(Tasks_.startDate), startFrom));
		}

		if(null != startTo) {
			params.add(cb.lessThanOrEqualTo(root.get(Tasks_.startDate), startTo));
		}

		if(null != endFrom) {
			params.add(cb.greaterThanOrEqualTo(root.get(Tasks_.endDate), endFrom));
		}

		if(null != endTo) {
			params.add(cb.lessThanOrEqualTo(root.get(Tasks_.endDate), endTo));
		}
		
		if(StringUtils.hasLength(keyword)) {
			var value = keyword.toLowerCase().concat("%");
			params.add(cb.or(
				cb.like(cb.lower(root.get(Tasks_.name)), value),
				cb.like(cb.lower(root.get(Tasks_.assignee)), value),
				cb.like(cb.lower(root.get(Tasks_.project).get(Project_.name)), value)
			));
		}
		
		return params.toArray(size -> new Predicate[size]);
	}

}
