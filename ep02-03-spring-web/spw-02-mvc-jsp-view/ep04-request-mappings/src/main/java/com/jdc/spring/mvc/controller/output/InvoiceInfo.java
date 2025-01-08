package com.jdc.spring.mvc.controller.output;

import java.time.LocalDateTime;
import java.util.UUID;

public record InvoiceInfo(
		UUID id,
		LocalDateTime issueAt,
		int totalCount,
		int totalAmount) {

}
