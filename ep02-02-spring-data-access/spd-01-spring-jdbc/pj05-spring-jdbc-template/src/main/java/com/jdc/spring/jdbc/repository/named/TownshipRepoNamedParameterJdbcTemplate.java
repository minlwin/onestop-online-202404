package com.jdc.spring.jdbc.repository.named;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.spring.jdbc.domain.TownshipDto;
import com.jdc.spring.jdbc.repository.TownshipRepo;

@Repository
public class TownshipRepoNamedParameterJdbcTemplate implements TownshipRepo {

	private static final String SELECT = """
			select ts.id, ts.name, ds.id districtId, ds.name districtName,
			dv.id divisionId, dv.name divisionName from TOWNSHIP ts 
			join DISTRICT ds on ds.id = ts.district_id 
			join DIVISION dv on dv.id = ds.division_id 
			""";
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private RowMapper<TownshipDto> rowMapper;
	
	public TownshipRepoNamedParameterJdbcTemplate() {
		rowMapper = new DataClassRowMapper<>(TownshipDto.class);
	}

	@Override
	public List<TownshipDto> search(Integer divisionId, Integer districtId, String name) {
		
		var sql = new StringBuffer(SELECT).append(" where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(null != divisionId) {
			sql.append(" and dv.id = :division");
			params.put("division", divisionId);
		}
		
		if(null != districtId) {
			sql.append(" and ds.id = :district");
			params.put("district", districtId);
		}
		
		if(StringUtils.hasLength(name)) {
			sql.append(" and lower(ts.name) like :name");
			params.put("name", name.toLowerCase().concat("%"));
		}
		
		return template.query(sql.toString(), params, rowMapper);
	}

	@Override
	public Optional<TownshipDto> findById(int id) {
		var sql = "%s where ts.id = :id".formatted(SELECT);
		return template.query(sql.toString(), Map.of("id", id), rowMapper).stream().findAny();
	}

}
