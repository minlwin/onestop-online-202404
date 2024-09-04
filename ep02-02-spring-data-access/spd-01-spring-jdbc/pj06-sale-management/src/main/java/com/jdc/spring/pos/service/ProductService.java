package com.jdc.spring.pos.service;

import com.jdc.spring.pos.domain.output.ProductDto;

public interface ProductService {

	ProductDto findByCode(String code);
}
