package com.jdc.spring.pos.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jdc.spring.pos.domain.output.ProductDto;

@Repository
public class ProductRepoImpl implements ProductRepo{

	@Override
	public Optional<ProductDto> findByCode(String code) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
