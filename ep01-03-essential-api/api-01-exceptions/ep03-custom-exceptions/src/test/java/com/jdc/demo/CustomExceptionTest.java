package com.jdc.demo;

import org.junit.jupiter.api.Test;

public class CustomExceptionTest {

	@Test
	void test() {
		
		try {
			var instance = new ReadFileAndShowLines();
			instance.readAndShow("test1.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
