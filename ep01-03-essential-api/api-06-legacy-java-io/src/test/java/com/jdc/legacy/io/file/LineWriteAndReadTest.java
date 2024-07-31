package com.jdc.legacy.io.file;

import org.junit.jupiter.api.Test;

import com.jdc.legacy.io.LineWriteAndRead;

public class LineWriteAndReadTest {

	@Test
	void test() {
		var service = new LineWriteAndRead("data.txt");
		service.start();
	}
}
