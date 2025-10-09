package com.jdc.courses.model;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.jdc.courses.api.output.PageInfo;
import com.jdc.courses.api.output.PageResult;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{
	
	private EntityManager entityManager;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		var criteriaQuery = queryFunc.apply(this.entityManager.getCriteriaBuilder());
		var query = this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public <R> PageResult<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
			Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc, int page, int size) {
		
		Long count = this.entityManager.createQuery(countFunc.apply(this.entityManager.getCriteriaBuilder()))
				.getSingleResult();
		
		var criteriaQuery = queryFunc.apply(this.entityManager.getCriteriaBuilder());
		var query = this.entityManager.createQuery(criteriaQuery);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		
		var contents = query.getResultList();
				
		return new PageResult<>(contents, new PageInfo(page, size, count.intValue()));
	}

	@Override
	public <R> Optional<R> searchOne(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
		var criteriaQuery = queryFunc.apply(this.entityManager.getCriteriaBuilder());
		var query = this.entityManager.createQuery(criteriaQuery);
		return Optional.ofNullable(query.getSingleResult());
	}

}
