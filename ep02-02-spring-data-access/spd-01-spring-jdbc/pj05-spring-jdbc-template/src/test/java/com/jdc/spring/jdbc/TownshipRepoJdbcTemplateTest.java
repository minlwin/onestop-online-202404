package com.jdc.spring.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jdc.spring.jdbc.repository.TownshipRepo;

@SpringBootTest
@ActiveProfiles("jdbc")
public class TownshipRepoJdbcTemplateTest {
	
	@Autowired
	private TownshipRepo repo;

	@ParameterizedTest
	@CsvFileSource(
		resources = "/township_find_by_id_found.txt", 
		delimiterString = "\t"
	)
	void test_find_by_id_found(int id, String name, 
			int districtId, String districtName,
			int divisionId, String divisionName) {
		
		var result = repo.findById(id);
		assertTrue(result.isPresent());
		
		result.ifPresent(dto -> {
			assertEquals(id, dto.id());
			assertEquals(name, dto.name());
			assertEquals(districtId, dto.districtId());
			assertEquals(districtName, dto.districtName());
			assertEquals(divisionId, dto.divisionId());
			assertEquals(divisionName, dto.divisionName());
		});
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 324})
	void test_find_by_id_not_found(int id) {
		var result = repo.findById(id);
		assertTrue(result.isEmpty());
	}
	
	@ParameterizedTest
	@CsvSource({
		",,,323",
		"15,,,45",
		",15,,3",
		"15,85,,13",
		"15,85,k,3",
		"15,85,ks,0",
	})
	void test_search(Integer divisionId, Integer districtId, String name, int size) {
		var result = repo.search(divisionId, districtId, name);
		assertEquals(size, result.size());
	}
	
}
