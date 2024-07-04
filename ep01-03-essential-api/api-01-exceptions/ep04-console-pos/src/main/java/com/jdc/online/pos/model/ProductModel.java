package com.jdc.online.pos.model;

import com.jdc.online.pos.model.input.ProductForm;
import com.jdc.online.pos.model.output.Product;

public interface ProductModel {

	static ProductModel getInstance() {
		return ProductModelImpl.getInstance();
	}

	int create(ProductForm form);

	Product[] search(String name);

	Product findById(int id);
	
}
