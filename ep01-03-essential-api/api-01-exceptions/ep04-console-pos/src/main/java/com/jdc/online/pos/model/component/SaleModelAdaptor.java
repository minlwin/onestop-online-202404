package com.jdc.online.pos.model.component;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.output.Sale;

public class SaleModelAdaptor implements TableViewModel {
	
	private Sale[] sales;
	
	public SaleModelAdaptor(Sale[] sales) {
		super();
		this.sales = sales;
	}

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String header() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] rows() {
		// TODO Auto-generated method stub
		return null;
	}

}
