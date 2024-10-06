package com.jdc.spring.trx.propagation;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CallerService {
	
	@Autowired
	private BaseService service;
	
	private SimpleJdbcInsert beforeInsert;
	private SimpleJdbcInsert afterInsert;
	

	public CallerService(DataSource dataSource) {
		
		beforeInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("before_tbl")
				.usingGeneratedKeyColumns("id")
				.usingColumns("message");
		afterInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("after_tbl");
		
	}

	@Transactional
	public int create(String before, String baseStart, String baseEnd, String after) {
		
		var id = beforeInsert.executeAndReturnKey(Map.of("message", before))
				.intValue();
		
		service.create(id, baseStart, baseEnd);
		
		afterInsert.execute(Map.of("id", id, "message", after));
		
		return id;
	}

}
