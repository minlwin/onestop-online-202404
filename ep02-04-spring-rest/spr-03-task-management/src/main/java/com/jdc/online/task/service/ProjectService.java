package com.jdc.online.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.task.api.input.ModificationResult;
import com.jdc.online.task.api.input.ProjectForm;
import com.jdc.online.task.api.input.ProjectSearch;
import com.jdc.online.task.api.output.ProjectDetails;
import com.jdc.online.task.api.output.ProjectListItem;
import com.jdc.online.task.model.entity.Project;
import com.jdc.online.task.model.entity.Project_;
import com.jdc.online.task.model.repo.ProjectRepo;
import com.jdc.online.task.utils.ApiBusinessException;

import jakarta.persistence.criteria.JoinType;

@Service
@Transactional(readOnly = true)
public class ProjectService {
	
	@Autowired
	private ProjectRepo repo;

	@Transactional
	public ModificationResult<Integer> create(ProjectForm form) {
		
		checkBusinessRule(form);
		
		var entity = repo.save(form.entity());
		return ModificationResult.success(entity.getId());
	}

	@Transactional
	public ModificationResult<Integer> update(int id, ProjectForm form) {
		
		checkBusinessRule(form);
		
		var entity = repo.findById(id)
				.orElseThrow(() -> new ApiBusinessException("There is no project with id %d.".formatted(id)));
		
		form.update(entity);
		
		return ModificationResult.success(entity.getId());
	}

	public List<ProjectListItem> search(ProjectSearch search) {
		return repo.search(cb -> {
			var cq = cb.createQuery(ProjectListItem.class);
			var root = cq.from(Project.class);
			
			var tasks = root.join(Project_.tasks, JoinType.LEFT);
			
			ProjectListItem.select(cb, cq, root, tasks);
			
			cq.where(search.where(cb, root));
			
			var having = search.having(cb, root, tasks);
			
			if(having.length > 0) {
				cq.having(having);
			}
			
			cq.orderBy(cb.desc(root.get(Project_.id)));
			
			
			return cq;
		});
	}

	public ProjectDetails findById(int id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ApiBusinessException("There is no project with id %d.".formatted(id)));

		return ProjectDetails.from(entity);
	}
	
	private void checkBusinessRule(ProjectForm form) {
		if(!form.dueDate().isAfter(form.startDate())) {
			throw new ApiBusinessException("Due date must be later than start date.");
		}
	}

	
}
