package com.jdc.web.spring.service.input;

import java.util.List;

import com.jdc.web.spring.service.output.ShoppingCartItem;

import lombok.Data;

@Data
public class CheckOutForm {

	private String customerName;
	private String customerPhone;
	private String email;
	
	private List<ShoppingCartItem> items;
}
