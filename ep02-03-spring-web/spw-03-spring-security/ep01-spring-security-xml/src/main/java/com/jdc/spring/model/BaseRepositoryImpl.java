package com.jdc.spring.model;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> 
	implements BaseRepository<T, ID>{

	private EntityManager em;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		var criteriaQuery = queryFunc.apply(em.getCriteriaBuilder());
		var query = em.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public <R> PageInfo<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc, int page, int size) {
		
		var count = em.createQuery(countFunc.apply(em.getCriteriaBuilder()))
				.getSingleResult();
		
		var contents = em.createQuery(queryFunc.apply(em.getCriteriaBuilder()))
				.setMaxResults(size)
				.setFirstResult(page * size).getResultList();
		
		return new PageInfo<R>(contents, page, size, count);
	}

}
