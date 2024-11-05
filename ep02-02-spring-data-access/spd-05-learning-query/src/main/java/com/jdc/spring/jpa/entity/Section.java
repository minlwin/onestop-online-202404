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
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Section.searchUnderFees", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, s.course.hours, s.endAt, s.startTime, s.endTime, s.course.name, s.fees, s.days)  
		from Section s 
		where s.fees <= :fees""")
@NamedQuery(name = "Section.searchStartBetween", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, s.course.hours, s.endAt, s.startTime, s.endTime, s.course.name, s.fees, s.days)  
		from Section s 
		where s.id.startAt between :from and :to""")
@NamedQuery(name = "Section.searchStartTimeIn", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, s.course.hours, s.endAt, s.startTime, s.endTime, s.course.name, s.fees, s.days)  
		from Section s 
		where s.startTime in :list""")
//@NamedQuery(name = "Section.searchInDays", query = """
//		select new com.jdc.spring.jpa.entity.dto.SectionDto(
//		s.id, s.course.hours, s.endAt, s.startTime, s.endTime, s.course.name, s.fees, s.days)  
//		from Section s 
//		where :day member of s.days""")
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