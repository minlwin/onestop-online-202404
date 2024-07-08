package com.jdc.online.pos.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import com.jdc.console.app.exceptions.BusinessException;
import com.jdc.console.app.exceptions.ValidationException;
import com.jdc.console.app.utils.FormatUtils;
import com.jdc.online.pos.model.input.SaleItem;
import com.jdc.online.pos.model.output.Sale;
import com.jdc.online.pos.model.storage.SaleStorage;

public class SaleModelImpl extends AbstractModel implements SaleModel {

	private static final String FILE_NAME = "sales.obj";
	
	private static SaleModel instance;
	private static int ID;
	
	private Sale[] sales = {};
	
	public static SaleModel getInstance() {
		
		if(null == instance) {
			instance = new SaleModelImpl();
		}
		
		return instance;
	}
	
	public SaleModelImpl() {
		// restore states
		try (var input = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			var result = input.readObject();
			
			if(null != result && result instanceof SaleStorage(var id, var data)) {
				ID = id;
				this.sales = data;
			}
		} catch (Exception e) {
		}
	}

	@Override
	public Sale create(SaleItem[] cart) {
		
		validate(cart);
		
		var sale = new Sale(++ ID, LocalDateTime.now(), cart);
		
		sales = Arrays.copyOf(sales, sales.length + 1);
		sales[sales.length - 1] = sale;
		
		// save state
		try (var output = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			
			output.writeObject(new SaleStorage(ID, sales));
			
		} catch (Exception e) {
		}
		
		return sale;
	}

	private void validate(SaleItem[] cart) {
		if(null == cart || cart.length == 0) {
			throw new BusinessException("Please add items to cart.");
		}
		
		String [] messages = {};
		
		for(var item : cart) {
			try {
				super.validate(item);
			} catch (ValidationException e) {
				for(var message : e.getMessages()) {
					messages = Arrays.copyOf(messages, messages.length + 1);
					messages[messages.length - 1] = message;
				}
			}
		}
		
		if(messages.length > 0) {
			throw new ValidationException(messages);
		}
	}

	@Override
	public Sale findById(int id) {
		
		for(var sale : sales) {
			if(sale.id() == id) {
				return sale;
			}
		}
		
		throw new BusinessException("Please enter valid sale id");
	}

	@Override
	public Sale[] findByDate(String dateValue) {
		
		try {
			Sale[] result = {};
			var date = (null == dateValue || dateValue.isBlank()) ? LocalDate.now() : LocalDate.parse(dateValue, FormatUtils.DATEF);
			
			for(var sale : sales) {
				if(sale.saleAt().toLocalDate().equals(date)) {
					result = Arrays.copyOf(result, result.length + 1);
					result[result.length - 1] = sale;
				}
			}
		
			return result;
		} catch (DateTimeParseException e) {
			throw new BusinessException("Please enter date with yyyy-MM-dd format.");
		}

	}

}
