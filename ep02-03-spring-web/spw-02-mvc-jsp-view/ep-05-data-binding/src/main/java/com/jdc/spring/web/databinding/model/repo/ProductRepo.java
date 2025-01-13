package com.jdc.spring.web.databinding.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.web.databinding.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
