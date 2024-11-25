package com.jdc.spring.jpa.base;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.persistence.LockModeType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>{

	// f(T)=R
	List<T> searchEntity(Function<CriteriaBuilder, CriteriaQuery<T>> queryFunc);
	Long count(Function<CriteriaBuilder, CriteriaQuery<Long>> queryFunc);
	<R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc);
	
	Optional<T> findById(ID id, LockModeType lock);
	
	void lock(T entity, LockModeType lock);
}
