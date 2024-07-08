package com.jdc.online.pos.features;

import java.util.Arrays;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.exceptions.BusinessException;
import com.jdc.console.app.exceptions.ConsoleAppException;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.SaleModel;
import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.utils.ProductTableHelper;

public class FeatureForAddSale extends AbstractFeature{

	private static final int SIZE = 10;

	public FeatureForAddSale(int id) {
		super(id, "Create Sale");
	}

	@Override
	public void doBusiness() {
		
		SaleItem [] cart = {};
		
		// Show Products List
		System.out.println("Please select products.");
		var products = ProductModel.getInstance().search(null);
		ProductTableHelper.getTableView(products).draw();
		System.out.println();
		
		var skipAsking = false;

		do {
			
			try {
				
				skipAsking = false;
				
				System.out.println("Add Item");
				
				// Get Product ID
				var id = UserInputs.readInt(SIZE, "Product ID");
				var product = ProductModel.getInstance().findById(id);
				// Show Price
				System.out.printf("%-10s : %s%n", "Name", product.name());
				System.out.printf("%-10s : %s%n", "Price", FormatUtils.DECIF.format(product.price()));

				// Get Quantity
				var quantity = UserInputs.readInt(SIZE, "Quantity");
				
				// Add Item To Cart
				var item = new SaleItem(product, quantity);
				cart = addItem(item, cart);
				
				// Show Total for Item
				System.out.printf("%-10s : %s%n%n", "Total", FormatUtils.DECIF.format(item.getTotal()));

			} catch (BusinessException e) {
				System.out.printf("Error : %s%n%n", e.getMessage());
				skipAsking = true;
			}
			
		} while(skipAsking || !isEmptyInCart());
		
		
		try {
			if(cart.length > 0) {
				// Register Sale History
				var sale = SaleModel.getInstance().create(cart);
				System.out.println("Sale History");
				// Show Sale Id
				System.out.printf("%-10s : %s%n", "Sale ID", sale.id());
				// Show Total Item
				System.out.printf("%-10s : %s%n", "Item Count", sale.getItemCount());
				// Show All Total Amount
				System.out.printf("%-10s : %s%n", "All Total", FormatUtils.DECIF.format(sale.getAllTotal()));
			}
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

	private SaleItem[] addItem(SaleItem item, SaleItem[] cart) {
		
		var newCart = Arrays.copyOf(cart, cart.length + 1);
		newCart[newCart.length - 1] = item;
		
		return newCart;
	}

	private boolean isEmptyInCart() {
		var result = UserInputs.readString("More Item (Y/Other)");
		System.out.println();
		return !"Y".equalsIgnoreCase(result);
	}

}
