package com.jdc.spring.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.mvc.model.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
