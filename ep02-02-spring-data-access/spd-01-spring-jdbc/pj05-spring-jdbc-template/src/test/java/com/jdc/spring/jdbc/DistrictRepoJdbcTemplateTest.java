package com.jdc.spring.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.jdbc.repository.DistrictRepo;

@SpringBootTest
public class DistrictRepoJdbcTemplateTest {
	
	@Autowired
	private DistrictRepo repo;

	@ParameterizedTest
	@CsvFileSource(resources = "/test_find_by_id_found.txt", delimiter = '\t')
	void test_find_by_id_found(int id, String name, int divisionId, String divisionName, long townships) {
		
		var result = repo.findById(id);
		
		assertTrue(result.isPresent());
		
		result.ifPresent(dto -> {
			assertEquals(id, dto.id());
			assertEquals(name, dto.name());
			assertEquals(divisionId, dto.divisionId());
			assertEquals(divisionName, dto.divisionName());
			assertEquals(townships, dto.townships());
		});
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 86})
	void test_find_by_id_not_found(int id) {
		var result = repo.findById(id);
		assertTrue(result.isEmpty());
	}
	
	@ParameterizedTest
	@CsvSource({
		",,85",
		"13,,14",
		",ma,7",
		"13,m,4",
		"13,me,0"
	})
	void test_search(Integer divisionId, String name, int size) {
		var result = repo.search(divisionId, name);
		assertEquals(size, result.size());
	}
}
