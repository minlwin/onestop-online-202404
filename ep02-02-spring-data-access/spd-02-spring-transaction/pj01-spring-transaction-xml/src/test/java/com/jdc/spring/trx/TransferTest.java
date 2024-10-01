package com.jdc.spring.trx;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class TransferTest {

	@Test
	void test() {
		System.out.println("Demo");
	}
}
