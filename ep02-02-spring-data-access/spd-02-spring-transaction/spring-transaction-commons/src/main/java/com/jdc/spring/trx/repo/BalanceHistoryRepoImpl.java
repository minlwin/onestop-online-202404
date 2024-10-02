package com.jdc.spring.trx.repo;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.spring.trx.dto.BalanceHistoryForm;

@Repository
public class BalanceHistoryRepoImpl implements BalanceHistoryRepo {
	
	private SimpleJdbcInsert insert;
	
	public BalanceHistoryRepoImpl(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource)
				.withTableName("balance_history");
	}

	@Override
	public void create(BalanceHistoryForm history) {
		insert.execute(new SimplePropertySqlParameterSource(history));
	}

}
