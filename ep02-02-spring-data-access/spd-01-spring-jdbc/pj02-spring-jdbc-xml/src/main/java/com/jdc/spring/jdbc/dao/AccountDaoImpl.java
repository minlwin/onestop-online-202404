package com.jdc.spring.jdbc.dao;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.jdc.spring.jdbc.dto.AccountDto;
import com.jdc.spring.jdbc.dto.AccountFrom;

public class AccountDaoImpl implements AccountDao {
	
	private JdbcTemplate template;
	private RowMapper<AccountDto> rowMapper;

	public AccountDaoImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		rowMapper = new DataClassRowMapper<>(AccountDto.class);
	}
	
	@Override
	public int create(AccountFrom form) {

		var keys = new GeneratedKeyHolder();
		
		template.update(con -> {
			var stmt = con.prepareStatement("insert into ACCOUNT (name, phone) values (?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, form.name());
			stmt.setString(2, form.phone());
			
			return stmt;
		}, keys);
		
		return keys.getKey().intValue();
	}

	@Override
	public long count() {
		return template
			.queryForObject("select count(id) from ACCOUNT", Long.class);
	}

	@Override
	public AccountDto findById(int id) {
		return template.queryForObject("select * from ACCOUNT where id = ?", rowMapper, id);
	}

}
