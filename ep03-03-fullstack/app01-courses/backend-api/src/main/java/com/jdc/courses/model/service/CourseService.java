package com.jdc.courses.model.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.courses.api.input.CourseSearch;
import com.jdc.courses.api.output.CourseListItem;
import com.jdc.courses.model.entity.Course;
import com.jdc.courses.model.repo.CourseRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	public List<CourseListItem> search(CourseSearch search) {
		
		Function<CriteriaBuilder, CriteriaQuery<CourseListItem>> queryFunc  = cb -> {
			var cq = cb.createQuery(CourseListItem.class);
			var root = cq.from(Course.class);
			
			CourseListItem.select(cq, root);
			cq.where(search.where(cb, root));
			
			return cq;
		};
		 
		return courseRepo.search(queryFunc);
	}
}
