package com.jdc.spring.jpa.entity;

import com.jdc.spring.jpa.entity.dto.CourseDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Course.findAll", query = "select c from Course c")
@NamedQuery(name = "Course.findAllNames", query = "select c.name from Course c")
@NamedQuery(name = "Course.countAll", query = "select count(c.id) from Course c")
@NamedQuery(name = "Course.findAverageHours", query = "select avg(c.hours) from Course c")
@NamedQuery(name = "Course.findSumFees", query = "select sum(c.fees) from Course c")
@NamedQuery(name = "Course.findAllDto", query = "select new com.jdc.spring.jpa.entity.dto.CourseDto(c.id, c.name, c.fees) from Course c")

@NamedNativeQuery(name = "Course.native.findAll", query = "select * from course", resultClass = Course.class)
@NamedNativeQuery(name = "Course.native.findAllDto", query = "select id, name, fees from course", resultClass = CourseDto.class)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	private int hours;
	private int fees;
}