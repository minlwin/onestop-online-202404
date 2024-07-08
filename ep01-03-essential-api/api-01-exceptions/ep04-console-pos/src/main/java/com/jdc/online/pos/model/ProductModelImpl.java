package com.jdc.online.pos.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.jdc.console.app.exceptions.BusinessException;
import com.jdc.online.pos.model.input.ProductForm;
import com.jdc.online.pos.model.output.Product;
import com.jdc.online.pos.model.storage.ProductStorage;

public class ProductModelImpl extends AbstractModel implements ProductModel {

	private static final String FILE_NAME = "products.obj";
	
	private static ProductModel instance;
	private static int ID;
	
	private Product[] data = {};
	
	private ProductModelImpl() {
		// Restore Last Data
		try(var input = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			var result = input.readObject();
			
			if(null != result && result instanceof ProductStorage(var id, var data)) {
				ID = id;
				this.data = data;
			}
		} catch (Exception e) {
			// Nothing to do
		}
	}
	
	public static ProductModel getInstance() {
		if(null == instance) {
			instance = new ProductModelImpl();
		}
		
		return instance;
	}
	
	@Override
	public int create(ProductForm form) {
		
		validate(form);
		
		var product = new Product(++ ID, form.name(), form.price());
		
		data = Arrays.copyOf(data, data.length + 1);
		data[data.length - 1] = product;
		
		// Save Storage
		try(var ouput = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			ouput.writeObject(new ProductStorage(ID, data));
		} catch (Exception e) {
			// Nothing to do
		}
		
		return ID;
	}

	@Override
	public Product[] search(String name) {
		
		var result = new Product[0];
		
		for(var product : data) {
			
			if(null == name || name.isBlank() 
					|| product.name().toLowerCase().startsWith(name.toLowerCase())) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = product;
			}
		}
		
		return result;
	}

	@Override
	public Product findById(int id) {
		
		for(var product : data) {
			if(product.id() == id) {
				return product;
			}
		}
		
		throw new BusinessException("Please enter valid product id");
	}

}
