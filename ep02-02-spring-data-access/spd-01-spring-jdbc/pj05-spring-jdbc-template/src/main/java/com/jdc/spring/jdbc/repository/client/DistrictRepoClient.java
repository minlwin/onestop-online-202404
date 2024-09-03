package com.jdc.spring.jdbc.repository.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jdc.spring.jdbc.domain.DistrictDto;
import com.jdc.spring.jdbc.repository.DistrictRepo;

@Repository
@Profile("client")
public class DistrictRepoClient implements DistrictRepo {
	
	private RowMapper<DistrictDto> rowMapper = new DataClassRowMapper<>(DistrictDto.class);
	
	@Value("${app.sql.district-select}")
	private String select;
	@Value("${app.sql.district-group-by}")
	private String groupBy;
	
	@Autowired
	private JdbcClient client;

	@Override
	public List<DistrictDto> search(Integer divisionId, String name) {
		
		var sql = new StringBuffer(select).append(" where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(null != divisionId) {
			sql.append(" and dv.id = :division");
			params.put("division", divisionId);
		}
		
		if(StringUtils.hasLength(name)) {
			sql.append(" and lower(ds.name) like :name");
			params.put("name", name.toLowerCase().concat("%"));
		}
		
		sql.append(" ").append(groupBy);
		
		return client.sql(sql.toString())
				.params(params)
				.query(rowMapper).list();
	}

	@Override
	public Optional<DistrictDto> findById(int id) {
		return client.sql("%s where ds.id = :id %s".formatted(select, groupBy))
				.params(Map.of("id", id))
				.query(rowMapper).optional();
	}

}
