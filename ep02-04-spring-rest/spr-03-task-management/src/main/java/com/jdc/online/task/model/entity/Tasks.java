package com.jdc.online.task.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Project project;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String assignee;

	@Column(nullable = false)
	private LocalDate dueDate;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private String description;
}
