package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.input.ProductForm;

public class FeatureForAddProduct extends AbstractFeature{

	private static final int SIZE = 6;
	
	private ProductModel model;

	public FeatureForAddProduct(int id) {
		super(id, "Create Product");
		model = ProductModel.getInstance();
	}

	@Override
	public void doBusiness() {
	
		// Get Product Name
		var name = UserInputs.readString(SIZE, "Name");
		
		// Get Sale Price
		var price = UserInputs.readInt(SIZE, "Price");
		
		// Add to Product Model
		var form = new ProductForm(name, price);
		
		var id = model.create(form);
		
		// Show Result
		System.out.printf("%s has been created with id %d.%n".formatted(name, id));
	}

}
