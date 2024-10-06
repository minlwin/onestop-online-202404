package com.jdc.spring.trx.propagation;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService {
	
	private SimpleJdbcInsert insertStart;
	private SimpleJdbcInsert insertEnd;
	
	public BaseService(DataSource dataSource) {
		insertStart = new SimpleJdbcInsert(dataSource)
				.withTableName("base_start_tbl");
		insertEnd = new SimpleJdbcInsert(dataSource)
				.withTableName("base_end_tbl");
	}

	@Transactional
	public void create(int id, String baseStart, String baseEnd) {
		insertStart.execute(Map.of("id", id, "message", baseStart));
		insertEnd.execute(Map.of("id", id, "message", baseEnd));
	}

}
