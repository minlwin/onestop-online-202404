package com.jdc.online.pos.features;

import com.jdc.console.app.AbstractFeature;
import com.jdc.console.app.UserInputs;
import com.jdc.console.app.component.TableView;
import com.jdc.console.app.component.TableViewData;
import com.jdc.console.app.component.TableViewData.ColumnAlignment;
import com.jdc.console.app.component.TableViewModelBase;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.ProductModel;
import com.jdc.online.pos.model.output.Product;

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
		
		var tableData = convert(products);
		
		var adaptor = new TableViewModelBase(tableData);
		
		// Show Result
		var table = new TableView(adaptor);
		table.draw();		
	}
	
	private TableViewData convert(Product[] products) {
		
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
		
		return new TableViewData(columns, headers, contents);
	}

}
