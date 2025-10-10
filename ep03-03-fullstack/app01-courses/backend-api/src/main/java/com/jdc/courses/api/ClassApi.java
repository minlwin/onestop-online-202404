package com.jdc.courses.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.courses.api.input.ClassForm;
import com.jdc.courses.api.input.ClassSearch;
import com.jdc.courses.api.output.ClassDetails;
import com.jdc.courses.api.output.ClassListItem;
import com.jdc.courses.api.output.ModificationResult;
import com.jdc.courses.api.output.PageResult;
import com.jdc.courses.model.service.ClassService;

@RestController
@RequestMapping("classes")
public class ClassApi {
	
	@Autowired
	private ClassService service;

	@GetMapping
	PageResult<ClassListItem> search(ClassSearch search, 
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		return service.search(search, page, size);
	}
	
	@GetMapping("{id}")
	ClassDetails findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	ModificationResult<Integer> create(
			@Validated @RequestBody ClassForm form) {
		return service.create(form);
	}

	@PutMapping("{id}")
	ModificationResult<Integer> update(@PathVariable int id,
			@Validated @RequestBody ClassForm form) {
		return service.update(id, form);
	}
}
