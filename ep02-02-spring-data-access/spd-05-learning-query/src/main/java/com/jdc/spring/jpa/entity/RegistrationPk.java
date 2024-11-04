package com.jdc.spring.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class RegistrationPk {

	@Column(name = "course_id")
	private int courseId;

	@Column(name = "start_at")
	private LocalDate startAt;
	
	@Column(name = "student_id")
	private int studentId;


}