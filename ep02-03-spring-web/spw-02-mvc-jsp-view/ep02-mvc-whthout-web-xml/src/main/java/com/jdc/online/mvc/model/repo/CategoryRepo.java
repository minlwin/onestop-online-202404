package com.jdc.online.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.online.mvc.model.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
