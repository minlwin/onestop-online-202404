package com.jdc.spring.pos.service.data;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.jdc.spring.pos.domain.input.SaleItem;
import com.jdc.spring.pos.domain.input.ShoppingCart;

public class ErrorForSaleItemProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
			emptyProductCode(),
			invalidProductCode(),
			zeroQuantity(),
			zeroUnitPrice()
		);
	}

	private Arguments zeroUnitPrice() {
		var cart = ShoppingCart.withName("Aung Aung");
		
		var item = new SaleItem();
		item.setProductCode("P0001");
		item.setQuantity(3);
		item.setUnitPrice(0);
		cart.setItems(List.of(item));
		
		return Arguments.of(
			cart, "Please enter unit price."	
		);	
	}

	private Arguments zeroQuantity() {
		var cart = ShoppingCart.withName("Aung Aung");
		
		var item = new SaleItem();
		item.setProductCode("P0001");
		item.setQuantity(0);
		item.setUnitPrice(1000);
		cart.setItems(List.of(item));
		
		return Arguments.of(
			cart, "Please enter quantity."	
		);	
	}

	private Arguments invalidProductCode() {
		var cart = ShoppingCart.withName("Aung Aung");
		
		var item = new SaleItem();
		item.setProductCode("P0001a");
		item.setQuantity(1);
		item.setUnitPrice(1000);
		cart.setItems(List.of(item));
		
		return Arguments.of(
			cart, "Invalid product code."	
		);
	}

	private Arguments emptyProductCode() {
		var cart = ShoppingCart.withName("Aung Aung");
		
		var item = new SaleItem();
		item.setProductCode("");
		item.setQuantity(1);
		item.setUnitPrice(1000);
		cart.setItems(List.of(item));
		
		return Arguments.of(
			cart, "Please enter product code."	
		);
	}

}
