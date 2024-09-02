package com.jdc.spring.jdbc.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.spring.jdbc.domain.DistrictDto;
import com.jdc.spring.jdbc.repository.DistrictRepo;

@Repository
@Profile("jdbc")
public class DistrictRepoJdbcTemplate implements DistrictRepo {
	
	private final String SELECT = """
			select ds.id, ds.name, dv.id divisionId, dv.name divisionName, 
			count(ts.id) townships from DISTRICT ds 
			join DIVISION dv on ds.division_id = dv.id 
			left join TOWNSHIP ts on ts.district_id = ds.id 
			""";
	
	private final String GROUP_BY = "GROUP BY ds.id, ds.name, dv.id, dv.name";
	
	@Autowired
	private JdbcTemplate template;
	private RowMapper<DistrictDto> rowMapper;
	
	public DistrictRepoJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(DistrictDto.class);
	}

	@Override
	public List<DistrictDto> search(Integer divisionId, String name) {
		
		var sql = new StringBuffer(SELECT).append(" where 1 = 1");
		var params = new ArrayList<Object>();
		
		if(null != divisionId) {
			sql.append(" and dv.id = ?");
			params.add(divisionId);
		}
		
		if(StringUtils.hasLength(name)) {
			sql.append(" and lower(ds.name) like ?");
			params.add(name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(GROUP_BY);
		
		return template.query(sql.toString(), rowMapper, params.toArray());
	}

	@Override
	public Optional<DistrictDto> findById(int id) {
		return template.query("%s where ds.id = ? %s".formatted(SELECT, GROUP_BY), rowMapper, id)
			.stream().findAny();
	}

}
