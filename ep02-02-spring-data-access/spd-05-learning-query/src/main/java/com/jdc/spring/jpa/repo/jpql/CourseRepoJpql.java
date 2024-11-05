package com.jdc.spring.jpa.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.Course;
import com.jdc.spring.jpa.entity.dto.CourseDto;
import com.jdc.spring.jpa.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class CourseRepoJpql implements CourseRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Course> findAll() {
		var query = em.createNamedQuery("Course.findAll", Course.class);
		return query.getResultList();
	}

	@Override
	public List<String> findAllName() {
		var query = em.createNamedQuery("Course.findAllNames", String.class);
		return query.getResultList();
	}

	@Override
	public Long countAll() {
		var query = em.createNamedQuery("Course.countAll", Long.class);
		return query.getSingleResult();
	}

	@Override
	public Double findAverageHours() {
		var query = em.createNamedQuery("Course.findAverageHours", Double.class);
		return query.getSingleResult();
	}

	@Override
	public Integer findSumFees() {
		var query = em.createNamedQuery("Course.findSumFees", Integer.class);
		return query.getSingleResult();
	}

	@Override
	public List<CourseDto> findAllDto() {
		var query = em.createNamedQuery("Course.findAllDto", CourseDto.class);
		return query.getResultList();
	}

}
