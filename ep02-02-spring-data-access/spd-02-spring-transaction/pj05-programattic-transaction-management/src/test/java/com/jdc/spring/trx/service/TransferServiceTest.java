package com.jdc.spring.trx.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.jdc.spring.trx.event.TransferServiceEvent;
import com.jdc.spring.trx.service.dto.TransferForm;

@SpringBootTest
@Sql(scripts = "classpath:/init.sql", executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
public class TransferServiceTest {

	@Autowired
	private TransferServiceEvent service;
	
	@ParameterizedTest
	@CsvSource("C001,C002,90000,Test Transfer")
	void test(@AggregateWith(TransformAggregator.class) TransferForm form) {
		var result = service.transfer(form);
		assertEquals(1, result);
	}
}
