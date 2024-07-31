package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.CustomerWriteService;

public class CustomerWriteServiceTest {

	@Test
	void test() {
		new CustomerWriteService().start();
	}
}
