package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.CustomerReadService;

public class CustomerReadServiceTest {

	@Test
	void test() {
		var service = new CustomerReadService();
		var list = service.read();
		
		for(var c : list) {
			System.out.println(c);
		}
	}
}
