package com.jdc.spring.jpa.repo.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.Student;
import com.jdc.spring.jpa.entity.Student_;
import com.jdc.spring.jpa.repo.StudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class StudentRepoCriteria implements StudentRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Student> findByPhone(String phone) {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Student.class);
		
		var root = cq.from(Student.class);
		cq.select(root);
		
		cq.where(cb.equal(root.get(Student_.phone), phone));
		
		var query = em.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public List<Student> findByKeyword(String keyword) {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Student.class);
		
		var root = cq.from(Student.class);
		cq.select(root);
		
		var criteria = cb.or(
			cb.like(cb.lower(root.get(Student_.name)), keyword.toLowerCase().concat("%")),
			cb.like(cb.lower(root.get(Student_.phone)), keyword.toLowerCase().concat("%")),
			cb.like(cb.lower(root.get(Student_.email)), keyword.toLowerCase().concat("%"))
		);
		
		cq.where(criteria);

		var query = em.createQuery(cq);
		return query.getResultList();
	}

}
