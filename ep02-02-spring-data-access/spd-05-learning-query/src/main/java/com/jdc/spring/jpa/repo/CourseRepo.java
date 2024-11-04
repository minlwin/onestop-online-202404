package com.jdc.spring.jpa.repo;

import java.util.List;

import com.jdc.spring.jpa.entity.Course;
import com.jdc.spring.jpa.entity.dto.CourseDto;

public interface CourseRepo {

	List<Course> findAll();
	List<String> findAllName();
	Long countAll();
	Double findAverageHours();
	Integer findSumFees();
	
	List<CourseDto> findAllDto();
}
