package com.jdc.online.pos.model.component;

import static com.jdc.console.app.utils.FormatUtils.DECIF;
import static com.jdc.console.app.utils.FormatUtils.FMT_NUMBER;
import static com.jdc.console.app.utils.FormatUtils.FMT_STRING;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.output.Product;

public class ProductModelAdaptor implements TableViewModel {

	private Product[] products;
	
	private static final String HEADER_ID = "Id";
	private static final String HEADER_NAME = "Name";
	private static final String HEADER_PRICE = "Price";
	
	private int idLength = HEADER_ID.length() + 2;
	private int nameLength = HEADER_NAME.length() + 2;
	private int priceLength = HEADER_PRICE.length() + 2;
	
	private String rowFormat;
	
	public ProductModelAdaptor(Product[] products) {
		super();
		this.products = products;
		
		for(var product : this.products) {
			
			if(String.valueOf(product.id()).length() + 2 > idLength) {
				idLength = String.valueOf(product.id()).length() + 2;
			}
			
			if(product.name().length() + 2 > nameLength) {
				nameLength = product.name().length() + 2;
			}
			
			if(DECIF.format(product.price()).length() + 2 > priceLength) {
				priceLength = DECIF.format(product.price()).length() + 2;
			}
		}	
		
		setRowFormat();
	}

	@Override
	public int maxSize() {
		return idLength + nameLength + priceLength;
	}

	@Override
	public String header() {
		return rowFormat.formatted(HEADER_ID, HEADER_NAME, HEADER_PRICE);
	}

	@Override
	public String[] rows() {
		
		var rows = new String[products.length];
		
		for(var i = 0; i < products.length; i ++) {
			var product = products[i];
			rows[i] = rowFormat.formatted(product.id(), product.name(), DECIF.format(product.price()));
		}
		
		return rows;
	}
	
	private void setRowFormat() {
		
		var sb = new StringBuilder();
		sb.append(FMT_STRING.formatted(idLength));
		sb.append(FMT_STRING.formatted(nameLength));
		sb.append(FMT_NUMBER.formatted(priceLength));
		
		rowFormat = sb.toString();
	}

}
