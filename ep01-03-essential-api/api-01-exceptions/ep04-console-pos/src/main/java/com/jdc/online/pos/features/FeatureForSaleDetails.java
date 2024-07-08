package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BusinessException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.utils.SaleItemTableHelper;

public class FeatureForSaleDetails extends AbstractFeature{

	private static final int SIZE = 14;

	public FeatureForSaleDetails(int id) {
		super(id, "Sale Details");
	}

	@Override
	public void doBusiness() {
		
		try {
			
			// Get Sale ID
			var id = UserInputs.readInt(SIZE, "Enter Sale ID");
			
			// Find Sale History from Sale Model
			var sale = SaleModel.getInstance().findById(id);
			
			// Show Sale Details
			
			// Sale At
			System.out.printf("%-14s : %s%n", "Sale At" ,sale.saleAt().format(FormatUtils.DATE_TIMEF));
			
			// Total Count
			System.out.printf("%-14s : %s%n", "Items" , sale.getItemCount());
			
			// Total Amount
			System.out.printf("%-14s : %s%n%n", "Total Amount" , FormatUtils.DECIF.format(sale.getAllTotal()));
			
			// Sale Items
			System.out.println("Sale Items");
			SaleItemTableHelper.getTableView(sale.items()).draw();
			
		} catch (BusinessException e) {
			System.out.printf("Error : %s%n%n", e.getMessage());
			doBusiness();
		}
		
	}

}
