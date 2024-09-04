package com.jdc.spring.pos.repo;

import java.util.Optional;

import com.jdc.spring.pos.domain.output.ProductDto;

public interface ProductRepo {

	Optional<ProductDto> findByCode(String code);

}
