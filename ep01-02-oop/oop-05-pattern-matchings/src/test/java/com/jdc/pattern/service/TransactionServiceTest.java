package com.jdc.pattern.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.pattern.domain.AgentTransaction;
import com.jdc.pattern.domain.ConsumerTransaction;

public class TransactionServiceTest {
	
	private TransactionService service;
	
	@BeforeEach
	void initEach() {
		service = new TransactionService();
	}

	@ParameterizedTest
	@CsvSource({
		"1,Transfer,Aung Aung,10000",
		"2,Bill Payment,Nilar,1500",
	})
	void test_consumer(long id, String name, String consumerName, BigDecimal amount) {
		var input = new ConsumerTransaction(id, name, consumerName, amount);
		service.show(input);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,Cash Out,196 Store,10000",
		"2,Cash In,Ngway La Min,1500",
	})
	void test_agent(long id, String name, String consumerName, BigDecimal amount) {
		var input = new AgentTransaction(id, name, consumerName, amount);
		service.show(input);
	}
}
