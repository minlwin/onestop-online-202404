package com.jdc.courses.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.courses.api.input.CourseForm;
import com.jdc.courses.api.input.CourseSearch;
import com.jdc.courses.api.output.CourseDetails;
import com.jdc.courses.api.output.CourseListItem;
import com.jdc.courses.api.output.ModificationResult;
import com.jdc.courses.model.service.CourseService;

@RestController
@RequestMapping("courses")
public class CourseApi {
	
	@Autowired
	private CourseService courseService;

	@GetMapping
	List<CourseListItem> search(CourseSearch search) {
		return courseService.search(search);
	}
	
	@GetMapping("{id}")
	CourseDetails findById(@PathVariable int id) {
		return courseService.findById(id);
	}
	
	@PostMapping
	ModificationResult<Integer> create(
			@Validated @RequestBody CourseForm form) {
		return null;
	}

	@PutMapping("{id}")
	ModificationResult<Integer> update(@PathVariable int id,
			@Validated @RequestBody CourseForm form) {
		return null;
	}

}
