package com.jdc.spring.pos.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdc.spring.pos.domain.input.SaleItem;
import com.jdc.spring.pos.domain.output.SaleDetailsItem;

@Repository
public class SaleProductRepoImpl implements SaleProductRepo{

	@Override
	public void creae(int saleId, SaleItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SaleDetailsItem> findBySaleId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
