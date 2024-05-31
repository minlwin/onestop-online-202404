package com.jdc.demo.compose;

import org.junit.jupiter.api.Test;

public class ComposeTest {

	@Test
	void test() {
		
		var adder = new AdderApplication(new Calculator());
		adder.add(10, 5);
	}
}
