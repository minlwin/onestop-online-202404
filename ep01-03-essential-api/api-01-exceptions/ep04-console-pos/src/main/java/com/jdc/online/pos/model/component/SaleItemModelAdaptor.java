package com.jdc.online.pos.model.component;

import static com.jdc.console.app.utils.FormatUtils.DECIF;
import static com.jdc.console.app.utils.FormatUtils.FMT_NUMBER;
import static com.jdc.console.app.utils.FormatUtils.FMT_STRING;

import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.input.SaleItem;

public class SaleItemModelAdaptor implements TableViewModel {

	private SaleItem[] items;
	
	private static final String HEADER_NO = "No.";
 	private static final String HEADER_NAME = "Product";
 	private static final String HEADER_PRICE = "Price";
 	private static final String HEADER_QTY = "Qty";
 	private static final String HEADER_TOTAL = "Total";
 	
 	private int lengthNo = HEADER_NO.length() + 3;
 	private int lengthName = HEADER_NAME.length() + 3;
 	private int lengthPrice = HEADER_PRICE.length() + 3;
 	private int lengthQty = HEADER_QTY.length() + 3;
 	private int lengthTotal = HEADER_TOTAL.length() + 3;
 	
 	private String rowFormat;
 	 	
 	
	public SaleItemModelAdaptor(SaleItem[] items) {
		super();
		this.items = items;
		
		for(var item: this.items) {
			
			if(item.product().name().length() + 3 > lengthName) {
				lengthName = item.product().name().length() + 3;
			}
			
			if(DECIF.format(item.product().price()).length() + 3 > lengthPrice) {
				lengthPrice = DECIF.format(item.product().price()).length() + 3;
			}
			
			if(DECIF.format(item.count()).length() + 3 > lengthQty) {
				lengthQty = DECIF.format(item.count()).length() + 3;
			}

			if(DECIF.format(item.getTotal()).length() + 3 > lengthTotal) {
				lengthTotal = DECIF.format(item.getTotal()).length() + 3;
			}
		}
		
		setRowFormat();
	}

	@Override
	public int maxSize() {
		return lengthNo + lengthName + lengthPrice + lengthQty + lengthTotal;
	}

	@Override
	public String header() {
		return rowFormat.formatted(HEADER_NO, HEADER_NAME, HEADER_PRICE, HEADER_QTY, HEADER_TOTAL);
	}

	@Override
	public String[] rows() {
		
		var rows = new String[items.length];
		
		for(var i = 0; i < items.length; i ++) {
			var item = items[i];
			rows[i] = rowFormat.formatted(i + 1, item.product().name(), item.product().price(), item.count(), item.getTotal());
		}
		
		return null;
	}
	
	private void setRowFormat() {
		var sb = new StringBuilder();
		
		sb.append(FMT_STRING.formatted(lengthNo));
		sb.append(FMT_STRING.formatted(lengthName));
		sb.append(FMT_NUMBER.formatted(lengthPrice));
		sb.append(FMT_NUMBER.formatted(lengthQty));
		sb.append(FMT_NUMBER.formatted(lengthTotal));
		
		this.rowFormat = sb.toString();
	}

}
