package com.jdc.spring.jdbc.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.jdc.spring.jdbc.domain.TownshipDto;
import com.jdc.spring.jdbc.repository.TownshipRepo;

public class TownshipRepoJdbcTemplate implements TownshipRepo{
	
	private static final String SELECT = """
			select ts.id, ts.name, ds.id districtId, ds.name districtName,
			dv.id divisionId, dv.name divisionName from TOWNSHIP ts 
			join DISTRICT ds on ds.id = ts.district_id 
			join DIVISION dv on dv.id = ds.division_id 
			""";
	
	@Autowired
	private JdbcTemplate template;
	private RowMapper<TownshipDto> rowMapper;
	
	public TownshipRepoJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(TownshipDto.class);
	}

	@Override
	public List<TownshipDto> search(Integer divisionId, Integer districtId, String name) {
		
		var sql = new StringBuffer(SELECT).append(" where 1 = 1");
		var params = new ArrayList<Object>();
		
		if(null != divisionId) {
			sql.append(" and dv.id = ?");
			params.add(divisionId);
		}
		
		if(null != districtId) {
			sql.append(" and ds.id = ?");
			params.add(districtId);
		}
		
		if(StringUtils.hasLength(name)) {
			sql.append(" and lower(ts.name) like ?");
			params.add(name.toLowerCase().concat("%"));
		}
		
		return template.query(sql.toString(), rowMapper, params.toArray());
	}

	@Override
	public Optional<TownshipDto> findById(int id) {
		return template.query("%s where ts.id = ?".formatted(SELECT), 
				rowMapper, id).stream().findAny();
	}

}
