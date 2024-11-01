package com.jdc.spring.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public List<Student> findAll() {
		// select * from STUDENT
		var jpql = "select s from Student s";
		var query = em.createQuery(jpql, Student.class);
		return query.getResultList();
	}
	
	@Transactional
	public int deleteById(int id) {
		var student = em.find(Student.class, id);
		if(null != student) {
			em.remove(student);
		}
		
		return 0;
	}

	@Transactional
	public Student create(Student student) {
		em.persist(student);
		return student;
	}
	
	@Transactional
	public Student update(Student student) {
		return em.merge(student);
	}
}
