package com.jdc.spring.em.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.em.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TeacherRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Teacher create(Teacher teacher) {
		em.persist(teacher);
		return teacher;
	}
}
