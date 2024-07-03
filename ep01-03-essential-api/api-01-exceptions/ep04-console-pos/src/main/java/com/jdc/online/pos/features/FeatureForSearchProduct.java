package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.component.TableView;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.component.ProductModelAdaptor;

public class FeatureForSearchProduct extends AbstractFeature{

	public FeatureForSearchProduct(int id) {
		super(id, "Search Product");
	}

	@Override
	public void doBusiness() {
		
		// Get Product Name
		var name = UserInputs.readString("Name");
		
		// Search From Model
		var products = ProductModel.getInstance().search(name);
		
		
		// Show Result
		var adaptor = new ProductModelAdaptor(products);
		var table = new TableView(adaptor);
		table.draw();		
	}
	
	

}
