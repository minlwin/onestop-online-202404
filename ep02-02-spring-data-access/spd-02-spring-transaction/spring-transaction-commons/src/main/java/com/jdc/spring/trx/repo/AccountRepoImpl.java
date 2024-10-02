package com.jdc.spring.trx.repo;

import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jdc.spring.trx.dto.AccountInfo;
import com.jdc.spring.trx.dto.AmountUpdateForm;

@Repository
public class AccountRepoImpl implements AccountRepo {
	
	private static final String SELECT_SQL = "select * from account where account_num = :accountNum";
	private static final String UPDATE_SQL = "update account set version = :version, amount = :amount where account_num = :accountNum";
	
	private NamedParameterJdbcTemplate template;
	private RowMapper<AccountInfo> rowMapper;
	
	public AccountRepoImpl(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
		rowMapper = new DataClassRowMapper<>(AccountInfo.class);
	}

	@Override
	public Optional<AccountInfo> findByAccountId(String accountNum) {
		return template.query(SELECT_SQL, Map.of("accountNum", accountNum), rowMapper)
				.stream().findAny();
	}

	@Override
	public void updateAmount(AmountUpdateForm fromAmountForm) {
		template.update(UPDATE_SQL, new SimplePropertySqlParameterSource(fromAmountForm));
	}

}
