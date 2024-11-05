package com.jdc.spring.jpa.repo.jpql;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.Student;
import com.jdc.spring.jpa.repo.StudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class StudentRepoJpql implements StudentRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Student> findByPhone(String phone) {
		var query = em.createNamedQuery("Student.findByPhone", Student.class);
		query.setParameter(1, phone);
		return query.getResultList();
	}

	@Override
	public List<Student> findByKeyword(String keyword) {
		var query = em.createNamedQuery("Student.findByKeyword", Student.class);
		query.setParameter("keyword", keyword.toLowerCase().concat("%"));
		return query.getResultList();
	}

}
