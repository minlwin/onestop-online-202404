package com.jdc.legacy.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class CustomerReadService {

	private static final String FILE = "customers.obj";

	@SuppressWarnings("unchecked")
	public List<Customer> read() {
		try(var input = new ObjectInputStream(new FileInputStream(FILE))) {
			return (List<Customer>)input.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
