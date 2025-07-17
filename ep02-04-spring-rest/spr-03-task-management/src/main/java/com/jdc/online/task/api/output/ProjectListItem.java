package com.jdc.online.task.api.output;

import java.time.LocalDate;

import com.jdc.online.task.model.entity.Project;
import com.jdc.online.task.model.entity.Project_;
import com.jdc.online.task.model.entity.Tasks;
import com.jdc.online.task.model.entity.Tasks_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ListJoin;
import jakarta.persistence.criteria.Root;

public record ProjectListItem(
		int id,
		String name,
		LocalDate startDate,
		LocalDate dueDate,
		long tasks) {

	public static void select(CriteriaBuilder cb, CriteriaQuery<ProjectListItem> cq, Root<Project> root, ListJoin<Project, Tasks> tasks) {
		
		cq.multiselect(
			root.get(Project_.id),
			root.get(Project_.name),
			root.get(Project_.startDate),
			root.get(Project_.dueDate),
			cb.count(tasks.get(Tasks_.id))
		);
		
		cq.groupBy(
			root.get(Project_.id),
			root.get(Project_.name),
			root.get(Project_.startDate),
			root.get(Project_.dueDate)
		);
	}

	public static ProjectListItem from(Project project) {
		return new ProjectListItem(
				project.getId(), 
				project.getName(), 
				project.getStartDate(), 
				project.getDueDate(), 
				project.getTasks().size());
	}

}
