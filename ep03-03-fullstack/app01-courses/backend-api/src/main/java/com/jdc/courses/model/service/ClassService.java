package com.jdc.courses.model.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdc.courses.api.input.ClassForm;
import com.jdc.courses.api.input.ClassSearch;
import com.jdc.courses.api.output.ClassDetails;
import com.jdc.courses.api.output.ClassListItem;
import com.jdc.courses.api.output.ModificationResult;
import com.jdc.courses.api.output.PageResult;
import com.jdc.courses.api.output.Schedule;
import com.jdc.courses.model.repo.ClassesRepo;
import com.jdc.courses.model.repo.CourseRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Service
@Transactional(readOnly = true)
public class ClassService {

	@Autowired
	private ClassesRepo classesRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ObjectMapper objectMapper;

	public PageResult<ClassListItem> search(ClassSearch search, int page, int size) {
		
		Function<CriteriaBuilder, CriteriaQuery<ClassListItem>> queryFunc = null;
		
		Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc = null;
		
		return classesRepo.search(queryFunc, countFunc, page, size);
	}

	public ClassDetails findById(int id) {
		return classesRepo.findById(id)
				.map(a -> ClassDetails.from(a, this::convert))
				.orElseThrow();
	}
	
	@Transactional
	public ModificationResult<Integer> create(ClassForm form) {
		
		try {
			// Find Course
			var course = courseRepo.findById(form.courseId()).orElseThrow();
			
			// Convert Schedule List to JSON String
			var schedules = objectMapper.writeValueAsString(form.schedules());

			// Create Class Entity
			var entity = form.entity();
			
			entity.setCourse(course);
			entity.setSchedules(schedules);
			
			entity = classesRepo.save(entity);
			
			return new ModificationResult<>(entity.getId());

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	public ModificationResult<Integer> update(int id, ClassForm form) {
		
		try {
			var entity = classesRepo.findById(id).orElseThrow();
			// Find Course
			var course = courseRepo.findById(form.courseId()).orElseThrow();
			entity.setCourse(course);
			
			// Convert Schedule List to JSON String
			var schedules = objectMapper.writeValueAsString(form.schedules());
			entity.setSchedules(schedules);
			
			entity.setStartDate(form.startDate());
			entity.setType(form.classType());
			entity.setRemark(form.remark());
			
			entity.setUpdatedAt(LocalDateTime.now());
		
			return new ModificationResult<>(entity.getId());

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<Schedule> convert(String json) {
		try {
			return objectMapper.readValue(json, new TypeReference<List<Schedule>>() {});
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
