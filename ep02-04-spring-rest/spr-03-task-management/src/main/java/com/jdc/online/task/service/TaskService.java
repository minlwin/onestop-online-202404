package com.jdc.online.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.task.api.input.ModificationResult;
import com.jdc.online.task.api.input.TaskForm;
import com.jdc.online.task.api.input.TaskSearch;
import com.jdc.online.task.api.output.TaskDetails;
import com.jdc.online.task.api.output.TaskListItem;
import com.jdc.online.task.model.entity.Project;
import com.jdc.online.task.model.entity.Project_;
import com.jdc.online.task.model.entity.Tasks;
import com.jdc.online.task.model.entity.Tasks_;
import com.jdc.online.task.model.repo.ProjectRepo;
import com.jdc.online.task.model.repo.TaskRepo;
import com.jdc.online.task.utils.ApiBusinessException;

@Service
@Transactional(readOnly = true)
public class TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	@Autowired
	private ProjectRepo projectRepo;

	@Transactional
	public ModificationResult<Integer> create(TaskForm form) {
		
		var project = projectRepo.findById(form.projectId()).orElseThrow(
				() -> new ApiBusinessException("There is no project with id %d.".formatted(form.projectId())));

		checkBusinessRule(form, project);
		
		var entity = taskRepo.save(form.entity(project));
		return ModificationResult.success(entity.getId());
	}

	@Transactional
	public ModificationResult<Integer> update(int id, TaskForm form) {
		
		var entity = taskRepo.findById(id)
				.orElseThrow(() -> new ApiBusinessException("There is task with id %d.".formatted(id)));
		
		checkBusinessRule(form, entity.getProject());

		form.update(entity);
		return ModificationResult.success(id);
	}

	public List<TaskListItem> search(TaskSearch search) {
		return taskRepo.search(cb -> {
			var cq = cb.createQuery(TaskListItem.class);
			
			var root = cq.from(Tasks.class);
			TaskListItem.select(cq, root);
			
			cq.where(search.where(cb, root));
			
			cq.orderBy(
				cb.desc(root.get(Tasks_.project).get(Project_.id)),
				cb.desc(root.get(Tasks_.id))
			);
					
			return cq;
		});
	}

	public TaskDetails findById(int id) {
		var entity = taskRepo.findById(id)
				.orElseThrow(() -> new ApiBusinessException("There is task with id %d.".formatted(id)));
		return TaskDetails.from(entity);
	}

	private void checkBusinessRule(TaskForm form, Project project) {
		
		if(form.startDate() != null 
				&& form.endDate() != null
				&& form.startDate().isAfter(form.endDate())) {
			throw new ApiBusinessException("End date must be later than Start date.");
		}
		
		if(form.dueDate().isBefore(project.getStartDate())) {
			throw new ApiBusinessException("Due date must be later than Project Start date.");
		}
		
		if(null != form.startDate() && form.startDate().isBefore(project.getStartDate())) {
			throw new ApiBusinessException("Start date must be later than Project Start date.");
		}
		
		if(null != form.endDate() && form.endDate().isBefore(project.getStartDate())) {
			throw new ApiBusinessException("End date must be later than Project Start date.");
		}
	}


}
