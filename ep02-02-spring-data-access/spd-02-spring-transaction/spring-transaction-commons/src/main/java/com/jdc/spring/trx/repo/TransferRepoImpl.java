package com.jdc.spring.trx.repo;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.spring.trx.dto.TransferForm;

@Repository
public class TransferRepoImpl implements TransferRepo {

	private static final String UPDATE_SQL = "update transfer set status = :status where id = :id";
	
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate template;
	
	public TransferRepoImpl(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource)
				.withTableName("transfer")
				.usingGeneratedKeyColumns("id")
				.usingColumns(
						"account_from",
						"account_to",
						"amount",
						"remark");
	}
	
	@Override
	public int initiate(TransferForm form) {
		return insert.executeAndReturnKey(new SimplePropertySqlParameterSource(form))
				.intValue();
	}

	@Override
	public void updateStatus(int trxId, String status) {
		template.update(UPDATE_SQL, new MapSqlParameterSource()
				.addValue("status", status)
				.addValue("id", trxId));
	}

}
