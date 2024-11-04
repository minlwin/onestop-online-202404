package com.jdc.spring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jpa.repo.natives.CourseRepoNative;

@SpringBootTest
public class NativeQueryTest {

	@Autowired
	private CourseRepoNative repo;
	
	@Test
	void test() {
		
		var result = repo.findAllDto();
		System.out.println(result);
	}
}
