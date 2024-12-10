package com.jdc.web.spring.service.output;

import java.time.LocalDateTime;

import com.jdc.web.spring.entity.Category;

import lombok.Data;

@Data
public class CategoryDetails {

	private int id;
	private String name;
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public String getStatus() {
		return deleted ? "Deleted" : "Available";
	}
	
	public static CategoryDetails from(Category entity) {
		var details = new CategoryDetails();
		
		details.setId(entity.getId());
		details.setName(entity.getName());
		details.setDeleted(entity.isDeleted());
		details.setCreatedAt(entity.getCreatedAt());
		details.setUpdatedAt(entity.getUpdatedAt());
		
		return details;
	}
}
