package com.jdc.spring.pos.repo;

import java.util.List;

import com.jdc.spring.pos.domain.input.SaleItem;
import com.jdc.spring.pos.domain.output.SaleDetailsItem;

public interface SaleProductRepo {

	void creae(int saleId, SaleItem item);

	List<SaleDetailsItem> findBySaleId(int id);

}
