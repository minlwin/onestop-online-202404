package com.jdc.online.pos.model.component;

import static com.jdc.console.app.utils.FormatUtils.*;
import com.jdc.console.app.component.TableViewModel;
import com.jdc.online.pos.model.output.Sale;

public class SaleModelAdaptor implements TableViewModel {
	
	private Sale[] sales;
	
	private static String [] headers = {"Id", "Sale At", "Items", "Total"};
	private static int [] columnSizes;
	
	static {
		columnSizes = new int[headers.length];
		
		for(var i = 0; i < headers.length; i ++) {
			columnSizes[i] = headers[i].length() + 3;
		}
	}
	
	private String rowFormat;
	
	public SaleModelAdaptor(Sale[] sales) {
		super();
		this.sales = sales;
		
		for(var sale : sales) {
			
			if(String.valueOf(sale.id()).length() + 3 > columnSizes[0]) {
				columnSizes[0] = String.valueOf(sale.id()).length() + 3;
			}
			
			if(sale.saleAt().format(DATE_TIMEF).length() + 3 > columnSizes[1]) {
				columnSizes[1] = sale.saleAt().format(DATE_TIMEF).length() + 3;
			}
			
			if(String.valueOf(sale.getItemCount()).length() + 3 > columnSizes[2]) {
				columnSizes[2] = String.valueOf(sale.getItemCount()).length() + 3;
			}

			if(FMT_NUMBER.formatted(sale.getAllTotal()).length() + 3 > columnSizes[3]) {
				columnSizes[3] = FMT_NUMBER.formatted(sale.getAllTotal()).length() + 3;
			}
		}
		
		setRowFormat();
	}

	@Override
	public int maxSize() {
		
		var total = 0;
		
		for(var size : columnSizes) {
			total += size;
		}
		
		return total;
	}

	@Override
	public String header() {
		return rowFormat.formatted(headers[0], headers[1], headers[2], headers[3]);
	}

	@Override
	public String[] rows() {
		
		var rows = new String[sales.length];
		
		for(var i = 0; i < sales.length; i ++) {
			var sale = sales[i];
			rows[i] = rowFormat.formatted(
					sale.id(), 
					sale.saleAt().format(DATE_TIMEF),
					sale.getItemCount(), sale.getAllTotal());
		}
		
		return rows;
	}

	private void setRowFormat() {
		var sb = new StringBuffer();
		sb.append(FMT_STRING.formatted(columnSizes[0]));
		sb.append(FMT_STRING.formatted(columnSizes[1]));
		sb.append(FMT_NUMBER.formatted(columnSizes[2]));
		sb.append(FMT_NUMBER.formatted(columnSizes[3]));
		
		rowFormat = sb.toString();
	}


}
