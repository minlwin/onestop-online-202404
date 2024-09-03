package com.jdc.spring.jdbc.repository.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.spring.jdbc.domain.DivisionDto;
import com.jdc.spring.jdbc.repository.DivisionRepo;

@Repository
@Profile("client")
public class DivisionRepoClient implements DivisionRepo{
	
	@Autowired
	private JdbcClient client;
	private RowMapper<DivisionDto> rowMapper = new DataClassRowMapper<>(DivisionDto.class);

	@Value("${app.sql.division-select}")
	private String selectSql;
	@Value("${app.sql.division-group-by}")
	private String groupBy;
	
	@Override
	public List<DivisionDto> search(String name) {
		
		var sql = new StringBuffer(selectSql);
		var list = new ArrayList<Object>();
		
		if(StringUtils.hasLength(name)) {
			sql.append(" where lower(dv.name) like ?");
			list.add(name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(groupBy);
		
		return client.sql(sql.toString())
				.params(list)
				.query(rowMapper).list();
	}

	@Override
	public Optional<DivisionDto> findById(int id) {
		return client.sql("%s where dv.id = ? %s".formatted(selectSql, groupBy))
				.param(id)
				.query(rowMapper)
				.optional();
	}

}
