package com.jdc.spring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jpa.repo.criteria.CourseRepoCriteria;
import com.jdc.spring.jpa.repo.jpql.CourseRepoJpql;

@SpringBootTest
class CourseRepoTest {
	
	@Autowired
	private CourseRepoCriteria criteria;
	@Autowired
	private CourseRepoJpql jpql;

	@Test
	void findAllNamesTest() {
		var result1 = jpql.findAllDto();
		System.out.println(result1);
		
		var result2 = criteria.findAllDto();
		System.out.println(result2);
	}

}
