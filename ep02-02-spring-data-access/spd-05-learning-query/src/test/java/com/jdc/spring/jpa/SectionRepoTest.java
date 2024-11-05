package com.jdc.spring.jpa;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jpa.repo.criteria.SectionRepoCriteria;
import com.jdc.spring.jpa.repo.jpql.SectionRepoJpql;

@SpringBootTest
public class SectionRepoTest {

	@Autowired
	private SectionRepoJpql jpql;
	@Autowired
	private SectionRepoCriteria criteria;
	
	@Test
	void test() {
		System.out.println(jpql.searchInDays(DayOfWeek.MONDAY));
		System.out.println(criteria.searchInDays(DayOfWeek.MONDAY));
	}
}
