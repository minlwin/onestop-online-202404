package com.jdc.spring.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.mvc.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
