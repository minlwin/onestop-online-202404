package com.jdc.courses.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.jdc.courses.model.BaseRepository;
import com.jdc.courses.model.entity.Course;

public interface CourseRepo extends BaseRepository<Course, Integer>{

	Optional<Course> findOneByName(String name);
	
	@Query("select count(t) from Course t where name = :name")
	Long countByBame(String name);
}
