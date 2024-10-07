package com.jdc.spring.trx.propagation;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

	@Transactional(propagation = Propagation.NESTED)
	public void create(int id, String baseStart, String baseEnd) {
		
		insertStart.execute(new MapSqlParameterSource()
				.addValue("id", id)
				.addValue("message", baseStart));
		
		insertEnd.execute(new MapSqlParameterSource()
				.addValue("id", id)
				.addValue("message", baseEnd));
	}

}
