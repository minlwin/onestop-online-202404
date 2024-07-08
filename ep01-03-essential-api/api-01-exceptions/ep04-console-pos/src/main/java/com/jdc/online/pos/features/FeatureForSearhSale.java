package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.utils.SaleHistoryTableHelper;

public class FeatureForSearhSale extends AbstractFeature{

	public FeatureForSearhSale(int id) {
		super(id, "Sale History");
	}

	@Override
	public void doBusiness() {

		// Get Sale Date
		var date = UserInputs.readString("Enter Date");
		
		// Search from Model
		var sales = SaleModel.getInstance().findByDate(date);
		
		// Show Result
		SaleHistoryTableHelper.getTableView(sales).draw();
	}

}
