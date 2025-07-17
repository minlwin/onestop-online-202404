package com.jdc.online.task.api.output;

import java.time.LocalDate;
import java.util.List;

import com.jdc.online.task.model.entity.Project;

public record ProjectDetails(
		int id,
		String name,
		LocalDate startDate,
		LocalDate dueDate,
		String details,
		List<TaskListItem> tasks) {

	public static ProjectDetails from(Project entity) {
		return new ProjectDetails(
				entity.getId(), 
				entity.getName(), 
				entity.getStartDate(), 
				entity.getDueDate(), 
				entity.getDescription(), 
				entity.getTasks().stream().map(TaskListItem::from).toList());
	}

}
