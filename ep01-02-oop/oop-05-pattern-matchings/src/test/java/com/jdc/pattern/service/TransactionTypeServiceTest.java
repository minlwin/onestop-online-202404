package com.jdc.pattern.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.domain.TransactionTypeForCashOut;
import com.jdc.pattern.domain.TransactionTypeForTransfer;

public class TransactionTypeServiceTest {

	private TransactionTypeService service;
	
	@BeforeEach
	void init() {
		service = new TransactionTypeService();
	}
	
	@ParameterizedTest
	@CsvSource({
		"Cash Out,Thidar,196 Store"
	})
	void test_cash_out(String name,
			String consumerName,
			String agentShop) {
		var input = new TransactionTypeForCashOut(name, consumerName, agentShop);
		service.show(input);
	}
	
	@ParameterizedTest
	@CsvSource({
		"Transfer,Thidar,Nilar"
	})
	void test_transfer(String name,
			String transferFrom,
			String transferTo) {
		var input = new TransactionTypeForTransfer(name, transferFrom, transferTo);
		service.show(input);
	}
}
