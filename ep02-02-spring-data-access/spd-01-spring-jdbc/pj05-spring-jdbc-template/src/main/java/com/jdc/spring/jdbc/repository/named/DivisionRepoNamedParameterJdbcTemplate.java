package com.jdc.spring.jdbc.repository.named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.spring.jdbc.domain.DivisionDto;
import com.jdc.spring.jdbc.repository.DivisionRepo;

@Repository
@Profile("named")
public class DivisionRepoNamedParameterJdbcTemplate implements DivisionRepo {

	@Autowired
	private NamedParameterJdbcTemplate template;
	private RowMapper<DivisionDto> rowMapper;
	
	private static final String SELECT = """
			select dv.id, dv.name, count(ds.id) districts 
			from DIVISION dv join DISTRICT ds on dv.id = ds.division_id 
			""";
	
	private static final String GROUP_BY = "group by dv.id, dv.name";
	
	public DivisionRepoNamedParameterJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(DivisionDto.class);
	}
	
	@Override
	public List<DivisionDto> search(String name) {
		
		var sql = new StringBuffer(SELECT);
		var params = new HashMap<String, Object>();
		
		if(StringUtils.hasLength(name)) {
			sql.append(" where lower(dv.name) like :name");
			params.put("name", name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(GROUP_BY);
		
		return template.query(sql.toString(), params, rowMapper);
	}

	@Override
	public Optional<DivisionDto> findById(int id) {
		var sql = "%s where dv.id = :id %s".formatted(SELECT, GROUP_BY);
		return template.query(sql, Map.of("id", id), rowMapper).stream().findAny();
	}

}
