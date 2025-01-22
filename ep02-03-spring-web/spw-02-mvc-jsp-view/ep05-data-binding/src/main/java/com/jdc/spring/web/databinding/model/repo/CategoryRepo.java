package com.jdc.spring.web.databinding.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.web.databinding.model.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Optional<Category> findOneByName(String name);
}
