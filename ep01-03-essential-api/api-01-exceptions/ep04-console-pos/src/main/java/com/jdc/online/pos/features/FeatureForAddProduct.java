package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BusinessException;
import com.jdc.console.app.exceptions.ConsoleAppException;
import com.jdc.console.app.exceptions.ValidationException;
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
		
		try {
			// Get Product Name
			var name = UserInputs.readString(SIZE, "Name");
			
			// Get Sale Price
			var price = UserInputs.readInt(SIZE, "Price");
			
			// Add to Product Model
			var form = new ProductForm(name, price);
			
			var id = model.create(form);
			
			// Show Result
			System.out.printf("%s has been created with id %d.%n".formatted(name, id));
		} catch (ConsoleAppException | BusinessException e) {
			System.out.printf("Error : %s%n%n", e.getMessage());
			doBusiness();
		} catch (ValidationException e) {
			
			System.out.println("Validation Errors");
			
			for(var message : e.getMessages()) {
				System.out.println(message);
			}
			
			doBusiness();
		}
	
	}

}
