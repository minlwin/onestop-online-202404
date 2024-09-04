package com.jdc.spring.pos.domain.output;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SaleInfo {

	private int id;
	private String salePerson;
	private LocalDateTime saleAt;
	private long itemCount;
	private long totalAmount;
}
