package com.jdc.courses.model.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.courses.api.input.CourseForm;
import com.jdc.courses.api.input.CourseSearch;
import com.jdc.courses.api.output.CourseDetails;
import com.jdc.courses.api.output.CourseListItem;
import com.jdc.courses.api.output.ModificationResult;
import com.jdc.courses.exceptions.BusinessException;
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

	public CourseDetails findById(int id) {
		return courseRepo.findById(id).map(CourseDetails::from)
				.orElseThrow(() -> new BusinessException("There is no course with id %s.".formatted(id)));
	}

	@Transactional
	public ModificationResult<Integer> create(CourseForm form) {
		
		if(courseRepo.countByBame(form.name()) > 0) {
			throw new BusinessException("There is a course with name : %s.".formatted(form.name()));
		}
		
		var entity = courseRepo.save(form.entity());
		return new ModificationResult<Integer>(entity.getId());
	}

	@Transactional
	public ModificationResult<Integer> update(int id, CourseForm form) {
		
		var entity = courseRepo.findById(id)
				.orElseThrow(() -> new BusinessException("There is no course with id %s.".formatted(id)));
		
		if(!entity.getName().equals(form.name())) {
			if(courseRepo.countByBame(form.name()) > 0) {
				throw new BusinessException("There is a course with name : %s.".formatted(form.name()));
			}
		}
		
		entity.setName(form.name());
		entity.setLevel(form.level());
		entity.setDescription(form.description());
		entity.setUpdatedAt(LocalDateTime.now());

		return new ModificationResult<Integer>(entity.getId());
	}
}
