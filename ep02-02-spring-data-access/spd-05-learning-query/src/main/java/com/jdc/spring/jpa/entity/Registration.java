package com.jdc.spring.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Registration {

	@EmbeddedId
	private RegistrationPk id;
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
	@JoinColumn(name = "start_at", referencedColumnName = "start_at", insertable = false, updatable = false)
	private Section section;
	
	@Column(nullable = false)
	private LocalDateTime registAt;

}