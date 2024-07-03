package com.jdc.online.pos.model.input;

import com.jdc.online.pos.model.output.Product;
import com.jdc.online.validator.annotations.MinValue;
import com.jdc.online.validator.annotations.NotNull;

public record SaleItem(
		@NotNull(message = "Please select product.")
		Product product,
		@MinValue(value = 1, message = "Please enter item count.")
		int count
		) {

	public int getTotal() {
		return product.price() * count;
	}
}
