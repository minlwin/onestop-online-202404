package com.jdc.spring.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.spring.pos.domain.exceptions.PosBusinessException;
import com.jdc.spring.pos.domain.output.ProductDto;
import com.jdc.spring.pos.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo repo;

	@Override
	public ProductDto findByCode(String code) {
		
		if(!StringUtils.hasLength(code)) {
			throw new PosBusinessException("Please enter product code.");
		}
		
		return repo.findByCode(code)
				.orElseThrow(() -> new PosBusinessException("Invalid product code."));		
	}
}
