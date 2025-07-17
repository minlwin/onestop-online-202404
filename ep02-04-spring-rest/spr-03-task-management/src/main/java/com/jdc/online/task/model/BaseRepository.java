package com.jdc.online.task.model;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

	<R>List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc);
}
