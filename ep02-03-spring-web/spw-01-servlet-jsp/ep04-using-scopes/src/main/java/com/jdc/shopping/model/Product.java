package com.jdc.shopping.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String category;
	private int price;
}
