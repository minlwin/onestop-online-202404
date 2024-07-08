package com.jdc.online.pos.model.output;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.jdc.online.pos.model.input.SaleItem;

public record Sale(
		int id,
		LocalDateTime saleAt,
		SaleItem[] items
		) implements Serializable {

	public int getItemCount() {
		return items.length;
	}
	
	public int getAllTotal() {
		var total = 0;
		
		for(var item : items) {
			total += item.getTotal();
		}
		
		return total;
	}
	
}
