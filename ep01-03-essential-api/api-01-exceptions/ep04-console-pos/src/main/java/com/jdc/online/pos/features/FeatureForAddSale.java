package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;

public class FeatureForAddSale extends AbstractFeature{

	public FeatureForAddSale(int id) {
		super(id, "Create Sale");
	}

	@Override
	public void doBusiness() {
		
		// Show Products List
		
		do {
			
			// Get Product ID
			
			// Get Quantity
			
			// Show Total for Item
			
		} while(isEmptyInCart());
		
		// Register Sale History
	}

	private boolean isEmptyInCart() {
		return false;
	}

}
