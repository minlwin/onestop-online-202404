package com.jdc.demo.override;

import org.junit.jupiter.api.Test;

public class OverrideTest {

	@Test
	void test() {
		
		Child child = new Child();
		
		use(child);
	}
	
	void use(Parent data) {
		data.doSomething();
	}
}
