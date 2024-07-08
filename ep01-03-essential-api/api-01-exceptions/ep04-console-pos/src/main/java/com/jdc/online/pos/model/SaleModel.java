package com.jdc.online.pos.model;

import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.model.output.Sale;

public interface SaleModel {

	static SaleModel getInstance() {
		return SaleModelImpl.getInstance();
	}

	Sale create(SaleItem[] cart);
	
	Sale findById(int id);
	
	Sale[] findByDate(String dateValue);

}
