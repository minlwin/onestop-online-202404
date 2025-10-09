package com.jdc.courses.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.jdc.courses.model.consts.CourseLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private CourseLevel level;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(mappedBy = "course")
	private List<Classes> classes;
	
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
