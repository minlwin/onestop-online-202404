package com.jdc.online.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.online.mvc.model.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
