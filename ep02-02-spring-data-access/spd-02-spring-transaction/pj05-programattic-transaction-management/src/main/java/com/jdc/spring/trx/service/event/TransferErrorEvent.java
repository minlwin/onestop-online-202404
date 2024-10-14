package com.jdc.spring.trx.service.event;

public record TransferErrorEvent(
		int historyId,
		Exception exception) {

}
