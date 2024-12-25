package com.jdc.spring.mvc.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	private boolean deleted;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
}
