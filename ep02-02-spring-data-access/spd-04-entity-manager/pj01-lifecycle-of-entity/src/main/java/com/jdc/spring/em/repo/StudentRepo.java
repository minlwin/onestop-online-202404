package com.jdc.spring.em.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.em.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public int create(Student student) {
		em.persist(student);
		return student.getId();
	}
	
	@Transactional(readOnly = true)
	public Student findById(int id) {
		return em.find(Student.class, id);
	}
	
	@Transactional
	public Student update(int id, String name, String phone, String email) {
		var entity = em.find(Student.class, id);
		entity.setName(name);
		entity.setPhone(phone);
		entity.setEmail(email);
		return entity;
	}
	
	@Transactional
	public void delete(int id) {
		var entity = em.find(Student.class, id);
		em.remove(entity);
	}
}
