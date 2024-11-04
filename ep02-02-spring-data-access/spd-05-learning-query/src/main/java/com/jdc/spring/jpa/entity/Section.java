package com.jdc.spring.jpa.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.jdc.spring.jpa.entity.converter.DaysConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Section {

	@EmbeddedId
	private SectionPk id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;
	
	@Convert(converter = DaysConverter.class)
	private List<DayOfWeek> days;
	
	@Column(nullable = false)
	private String startTime;

	@Column(nullable = false)
	private String endTime;
	
	private LocalDate endAt;
	private int fees;

}