package com.jdc.online.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.online.task.api.input.ModificationResult;
import com.jdc.online.task.api.input.TaskForm;
import com.jdc.online.task.api.input.TaskSearch;
import com.jdc.online.task.api.output.TaskDetails;
import com.jdc.online.task.api.output.TaskListItem;

@Service
public class TaskService {

	public List<TaskListItem> search(TaskSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskDetails findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModificationResult<Integer> create(TaskForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModificationResult<Integer> update(int id, TaskForm form) {
		// TODO Auto-generated method stub
		return null;
	}

}
