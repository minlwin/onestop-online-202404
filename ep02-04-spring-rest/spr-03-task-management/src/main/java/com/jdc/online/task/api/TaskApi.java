package com.jdc.online.task.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.online.task.api.input.ModificationResult;
import com.jdc.online.task.api.input.TaskForm;
import com.jdc.online.task.api.input.TaskSearch;
import com.jdc.online.task.api.output.TaskDetails;
import com.jdc.online.task.api.output.TaskListItem;
import com.jdc.online.task.service.TaskService;

@RestController
@RequestMapping("tasks")
public class TaskApi {
	
	@Autowired
	private TaskService service;

	@GetMapping
	List<TaskListItem> search(TaskSearch search) {
		return service.search(search);
	}
	
	@GetMapping("{id}")
	TaskDetails findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	ModificationResult<Integer> create(@RequestBody TaskForm form) {
		return service.create(form);
	}
	
	@PutMapping("{id}")
	ModificationResult<Integer> update(
			@PathVariable int id,
			@RequestBody TaskForm form) {
		return service.update(id, form);
	}
	
}
