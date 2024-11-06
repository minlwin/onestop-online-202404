package com.jdc.spring.jpa.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Section.searchUnderFees", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, c.hours, s.endAt, s.startTime, s.endTime, c.name, s.fees, s.daysCol)  
		from Section s left join s.course c 
		where s.fees <= :fees""")
@NamedQuery(name = "Section.searchStartBetween", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, c.hours, s.endAt, s.startTime, s.endTime, c.name, s.fees, s.daysCol)  
		from Section s left join s.course c 
		where s.id.startAt between :from and :to""")
@NamedQuery(name = "Section.searchStartTimeIn", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, c.hours, s.endAt, s.startTime, s.endTime, c.name, s.fees, s.daysCol)  
		from Section s left join s.course c 
		where s.startTime in :list""")
@NamedQuery(name = "Section.searchInDays", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionDto(
		s.id, c.hours, s.endAt, s.startTime, s.endTime, c.name, s.fees, s.daysCol)  
		from Section s left join s.course c 
		where :day member of s.days""")
@NamedQuery(name = "Section.searchOverStudents", query = """
		select new com.jdc.spring.jpa.entity.dto.SectionWithStudents(
		s.id, s.endAt, c.name, count(r.id.studentId) students)  
		from Section s left join s.course c left join s.registration r 
		group by s.id, s.endAt, c.name 
		having count(r.id.studentId) >= :students 
		order by students desc""")
public class Section {

	@EmbeddedId
	private SectionPk id;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;

	@ElementCollection
	@CollectionTable(name = "SECTION_DAYS")
	private List<DayOfWeek> days;
	
	private String daysCol;
	
	@Column(nullable = false)
	private String startTime;

	@Column(nullable = false)
	private String endTime;
	
	private LocalDate endAt;
	private int fees;
	
	@OneToMany(mappedBy = "section")
	private List<Registration> registration;
	
	public void setDays(List<DayOfWeek> days) {
		this.days = days;
		if(days != null) {
			daysCol = days.stream().map(a -> a.name()).collect(Collectors.joining(","));
		} else {
			daysCol = null;
		}
	}

}