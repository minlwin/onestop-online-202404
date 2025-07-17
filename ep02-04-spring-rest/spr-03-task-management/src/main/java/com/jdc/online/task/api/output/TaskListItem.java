package com.jdc.online.task.api.output;

import java.time.LocalDate;

import com.jdc.online.task.model.entity.Project_;
import com.jdc.online.task.model.entity.Tasks;
import com.jdc.online.task.model.entity.Tasks_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record TaskListItem(
		int id,
		int projectId,
		String project,
		String name,
		String assignee,
		LocalDate duedate,
		LocalDate startDate,
		LocalDate endDate) {

	public static void select(CriteriaQuery<TaskListItem> cq, Root<Tasks> root) {
		cq.multiselect(
			root.get(Tasks_.id),
			root.get(Tasks_.project).get(Project_.id),
			root.get(Tasks_.project).get(Project_.name),
			root.get(Tasks_.name),
			root.get(Tasks_.assignee),
			root.get(Tasks_.dueDate),
			root.get(Tasks_.startDate),
			root.get(Tasks_.endDate)
		);
	}

	public static TaskListItem from(Tasks entity) {
		var project = entity.getProject();
		return new TaskListItem(
				entity.getId(), 
				project.getId(), 
				project.getName(), 
				entity.getName(), 
				entity.getAssignee(), 
				entity.getDueDate(), 
				entity.getStartDate(), 
				entity.getEndDate());
	}

}
