package com.jdc.online.pos.model;

import com.jdc.online.pos.model.input.ProductForm;

public interface ProductModel {

	int create(ProductForm form);
	
	static ProductModel getInstance() {
		return ProductModelImpl.getInstance();
	}

}
