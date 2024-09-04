package com.jdc.spring.pos.domain.output;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class SaleDetails {

	private int id;
	private String salePerson;
	private LocalDateTime saleAt;
	private List<SaleDetailsItem> items;
	
	public int getItemCount() {
		if(null != items && !items.isEmpty()) {
			return items.stream().mapToInt(a -> a.getQuantity())
					.sum();
		}
		
		return 0;
	}
	
	public int getTotal() {
		if(null != items && !items.isEmpty()) {
			return items.stream().mapToInt(a -> a.getTotal())
					.sum();
		}
		
		return 0;
	}

	public static SaleDetails from(SaleInfo saleInfo, List<SaleDetailsItem> items) {
		
		var details = new SaleDetails();
		details.setId(saleInfo.getId());
		details.setSalePerson(saleInfo.getSalePerson());
		details.setSaleAt(saleInfo.getSaleAt());
		
		details.setItems(items);
		
		return details;
	}
}
