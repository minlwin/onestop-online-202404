package com.jdc.online.pos.utils;

import com.jdc.console.app.component.TableView;
import com.jdc.console.app.component.TableViewData;
import com.jdc.console.app.component.TableViewData.ColumnAlignment;
import com.jdc.console.app.component.TableViewModelBase;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.output.Product;

public class ProductTableHelper {

	public static TableView getTableView(Product [] products) {
		var headers = new String[]{"Id", "Name", "Price"};
		var columns = new ColumnAlignment[] {ColumnAlignment.Left, ColumnAlignment.Left, ColumnAlignment.Right};
		
		String[][] contents = new String[products.length][];
		
		for(var i = 0; i < contents.length; i ++) {
			var product = products[i];
			contents[i] = new String[3];
			
			contents[i][0] = String.valueOf(product.id());
			contents[i][1] = product.name();
			contents[i][2] = FormatUtils.DECIF.format(product.price());
		}
		
		var data =  new TableViewData(columns, headers, contents);

		return new TableView(new TableViewModelBase(data));
	}
}
