package com.jdc.web.spring.service.input;

import lombok.Data;

@Data
public class CategoryForm {

	private String name;
	private boolean deleted;
	
	public void setDeleted(String status) {
		this.deleted = status.equals("Deleted");
	}
}
