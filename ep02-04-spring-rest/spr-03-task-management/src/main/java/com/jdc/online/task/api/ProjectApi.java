package com.jdc.online.task.api;

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

import com.jdc.online.task.api.input.ModificationResult;
import com.jdc.online.task.api.input.ProjectForm;
import com.jdc.online.task.api.input.ProjectSearch;
import com.jdc.online.task.api.output.ProjectDetails;
import com.jdc.online.task.api.output.ProjectListItem;
import com.jdc.online.task.service.ProjectService;

@RestController
@RequestMapping("projects")
public class ProjectApi {
	
	@Autowired
	private ProjectService service;

	/**
	 * GET -> /projects
	 * 
	 * @param search
	 * @return
	 */
	@GetMapping
	List<ProjectListItem> search(ProjectSearch search) {
		return service.search(search);
	}
	
	/**
	 * GET -> /projects/10
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	ProjectDetails findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/**
	 * POST -> /projects
	 * 
	 * @param form
	 * @return
	 */
	@PostMapping
	ModificationResult<Integer> create(@Validated @RequestBody ProjectForm form) {
		return service.create(form);
	}
	
	/**
	 * PUT -> /projects/10
	 * 
	 * @param id
	 * @param form
	 * @return
	 */
	@PutMapping("{id}")
	ModificationResult<Integer> update(@PathVariable int id, 
			@Validated @RequestBody ProjectForm form) {
		return service.update(id, form);
	}
}
