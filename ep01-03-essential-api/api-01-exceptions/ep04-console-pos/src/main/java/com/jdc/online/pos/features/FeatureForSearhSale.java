package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BusinessException;
import com.jdc.console.app.exceptions.ConsoleAppException;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.utils.SaleHistoryTableHelper;

public class FeatureForSearhSale extends AbstractFeature{

	public FeatureForSearhSale(int id) {
		super(id, "Sale History");
	}

	@Override
	public void doBusiness() {

		try {
			// Get Sale Date
			var date = UserInputs.readString("Enter Date");
			
			// Search from Model
			var sales = SaleModel.getInstance().findByDate(date);
			
			// Show Result
			SaleHistoryTableHelper.getTableView(sales).draw();
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
