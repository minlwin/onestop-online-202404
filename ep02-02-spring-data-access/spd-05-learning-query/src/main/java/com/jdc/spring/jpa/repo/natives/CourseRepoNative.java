package com.jdc.spring.jpa.repo.natives;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdc.spring.jpa.entity.Course;
import com.jdc.spring.jpa.entity.dto.CourseDto;
import com.jdc.spring.jpa.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CourseRepoNative implements CourseRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Course> findAll() {
		var query = em.createNamedQuery("Course.native.findAll", Course.class);
		return query.getResultList();
	}

	@Override
	public List<String> findAllName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double findAverageHours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findSumFees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> findAllDto() {
		var query = em.createNamedQuery("Course.native.findAllDto", CourseDto.class);
		return query.getResultList();
	}

}
