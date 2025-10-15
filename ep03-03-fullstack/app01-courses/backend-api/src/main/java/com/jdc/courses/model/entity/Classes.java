package com.jdc.courses.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.courses.model.consts.ClassType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Classes implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Course course;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Column(nullable = false)
	private int months;

	@Column(nullable = false)
	private ClassType type;
	
	private String remark;
	
	@Column(nullable = false)
	private String schedules;
	
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;	
}
