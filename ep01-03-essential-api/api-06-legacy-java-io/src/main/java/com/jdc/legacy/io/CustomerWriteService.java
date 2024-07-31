package com.jdc.legacy.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerWriteService {
	
	private static final String FILE = "customers.obj";
	
	private int id;
	private List<Customer> list = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	

	public void start() {
		
		while(true) {
			System.out.println("Add New Customer");
			
			var customer = getCustomer();
			
			if(null == customer) {
				break;
			}
			
			list.add(customer);
			System.out.println();
		}
		
		// Save Customers
		saveCustomers();
		
	}

	private void saveCustomers() {
		try(var output = new ObjectOutputStream(new FileOutputStream(FILE))) {
			output.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Customer getCustomer() {
		
		System.out.print("Enter Name : ");
		String name = scanner.nextLine();
		
		if(null == name || name.isEmpty()) {
			return null;
		}
		
		System.out.print("Enter Phone : ");
		String phone = scanner.nextLine();
		
		if(null == phone || phone.isEmpty()) {
			return null;
		}
		
		var customer = new Customer();
		customer.setName(name);
		customer.setPhone(phone);
		customer.setId(++ id);
		
		return customer;
	}
}
