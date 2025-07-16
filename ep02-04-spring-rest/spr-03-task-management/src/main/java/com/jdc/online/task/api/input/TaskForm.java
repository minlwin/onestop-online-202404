package com.jdc.online.task.api.input;

import java.time.LocalDate;

import com.jdc.online.task.model.entity.Project;
import com.jdc.online.task.model.entity.Tasks;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskForm(
		@NotNull(message = "Please select project.")
		Integer projectId,
		@NotBlank(message = "Please enter task name.")
		String name,
		@NotBlank(message = "Please enter assignee.")
		String assignee,
		@NotNull(message = "Please enter due date")
		LocalDate dueDate,
		LocalDate startDate,
		LocalDate endDate,
		String description) {

	public Tasks entity(Project project) {
		var entity = new Tasks();
		entity.setProject(project);
		update(entity);
		return entity;
	}

	public void update(Tasks entity) {
		entity.setName(name);
		entity.setAssignee(assignee);
		entity.setDueDate(dueDate);
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		entity.setDescription(description);
	}

}
