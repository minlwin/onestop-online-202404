package com.jdc.spring.pos.service.data;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SaleServiceFindByIdSuccess implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
			Arguments.of(1, "Thidar", List.of(
					new SaleItem("P0001", "Egg L Size", 500, 3)
			)),
			Arguments.of(2, "Nilar", List.of(
					new SaleItem("P0001", "Egg L Size", 500, 2),
					new SaleItem("P0002", "Egg M Size", 400, 2)
			)),
			Arguments.of(3, "Thidar", List.of(
					new SaleItem("P0002", "Egg M Size", 400, 1),
					new SaleItem("P0006", "Coke 500 ML", 1500, 4)
			))
		);
	}
	
	
	public static record SaleItem(String code, String name, int price, int quantity) {}

}
