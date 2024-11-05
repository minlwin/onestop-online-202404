package com.jdc.spring.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jpa.repo.criteria.StudentRepoCriteria;
import com.jdc.spring.jpa.repo.jpql.StudentRepoJpql;

@SpringBootTest
public class StudentRepoTest {

	@Autowired
	private StudentRepoJpql jpql;
	
	@Autowired
	private StudentRepoCriteria criteria;
	
	@Test
	void test() {
		System.out.println(jpql.findByKeyword("w"));
		System.out.println(criteria.findByKeyword("w"));
	}
}
