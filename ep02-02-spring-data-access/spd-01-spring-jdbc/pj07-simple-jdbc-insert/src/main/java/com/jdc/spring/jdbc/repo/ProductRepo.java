package com.jdc.spring.jdbc.repo;

import com.jdc.spring.jdbc.domain.ProductDetails;
import com.jdc.spring.jdbc.domain.ProductForm;

public interface ProductRepo {

	int create(ProductForm form);
	
	ProductDetails findById(int id);
}
