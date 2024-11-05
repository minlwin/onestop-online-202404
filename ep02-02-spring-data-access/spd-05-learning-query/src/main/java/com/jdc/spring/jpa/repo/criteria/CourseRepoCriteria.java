package com.jdc.spring.jpa.repo.criteria;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.jpa.entity.Course;
import com.jdc.spring.jpa.entity.Course_;
import com.jdc.spring.jpa.entity.dto.CourseDto;
import com.jdc.spring.jpa.repo.CourseRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
@Transactional(readOnly = true)
public class CourseRepoCriteria implements CourseRepo{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Course> findAll() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// "from Course c";
		Root<Course> root = cq.from(Course.class);
		
		// "select c";
		cq.select(root);
		
		TypedQuery<Course> query = em.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public List<String> findAllName() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(String.class);
		var root = cq.from(Course.class);
		
		cq.select(root.get(Course_.name));
		
		var query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Long countAll() {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Long.class);
		
		var root = cq.from(Course.class);
		
		// select count(c.id)
		cq.select(cb.count(root.get(Course_.id)));
		
		var query = em.createQuery(cq);
		
		return query.getSingleResult();
	}

	@Override
	public Double findAverageHours() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Double.class);
		
		var root = cq.from(Course.class);
		
		// select count(c.id)
		cq.select(cb.avg(root.get(Course_.hours)));
		
		var query = em.createQuery(cq);
		
		return query.getSingleResult();
	}

	@Override
	public Integer findSumFees() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Integer.class);
		
		var root = cq.from(Course.class);
		
		// select count(c.id)
		cq.select(cb.sum(root.get(Course_.fees)));
		
		var query = em.createQuery(cq);
		
		return query.getSingleResult();
	}

	@Override
	public List<CourseDto> findAllDto() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(CourseDto.class);
		
		var root = cq.from(Course.class);
		cq.multiselect(
			root.get(Course_.id),
			root.get(Course_.name),
			root.get(Course_.fees)
		);
		
		var query = em.createQuery(cq);

		return query.getResultList();
	}

}
