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

import com.jdc.spring.jdbc.domain.DistrictDto;
import com.jdc.spring.jdbc.repository.DistrictRepo;

@Repository
@Profile("named")
public class DistrictRepoNamedParameterJdbcTemplate implements DistrictRepo {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	private RowMapper<DistrictDto> rowMapper;
	
	private final String SELECT = """
			select ds.id, ds.name, dv.id divisionId, dv.name divisionName, 
			count(ts.id) townships from DISTRICT ds 
			join DIVISION dv on ds.division_id = dv.id 
			left join TOWNSHIP ts on ts.district_id = ds.id 
			""";
	
	private final String GROUP_BY = "GROUP BY ds.id, ds.name, dv.id, dv.name";
	
	public DistrictRepoNamedParameterJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(DistrictDto.class);
	}

	@Override
	public List<DistrictDto> search(Integer divisionId, String name) {
		
		var sql = new StringBuffer(SELECT).append(" where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(null != divisionId) {
			sql.append(" and dv.id = :division");
			params.put("division", divisionId);
		}
		
		if(StringUtils.hasLength(name)) {
			sql.append(" and lower(ds.name) like :name");
			params.put("name", name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(GROUP_BY);
		
		return template.query(sql.toString(), params, rowMapper);
	}

	@Override
	public Optional<DistrictDto> findById(int id) {
		
		var sql = "%s where ds.id = :id %s".formatted(SELECT, GROUP_BY);
		
		return template.query(sql, Map.of("id", id), rowMapper)
				.stream().findAny();
	}

}
