package com.jdc.online.nio2.files;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.jdc.online.nio.DistrictReaderWithLopping;
import com.jdc.online.nio.DistrictReaderWithStream;

public class DistrictReaderTest {

	@Test
	void test_looping() {
		
		var path = Path.of("data", "district.txt");
		
		var reader = new DistrictReaderWithLopping();
		
		var map = reader.read(path);
		
		System.out.println("""
				===========================
				Read via looping
				""");
		System.out.println(map);
		
		System.out.println();
	}
	
	@Test
	void test_streams() {
		
		var path = Path.of("data", "district.txt");
		
		var reader = new DistrictReaderWithStream();
		
		var map = reader.read(path);
		
		System.out.println("""
				===========================
				Read via looping
				""");
		System.out.println(map);
		
		System.out.println();
	}
}
