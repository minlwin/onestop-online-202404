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

import com.jdc.spring.jdbc.domain.TownshipDto;
import com.jdc.spring.jdbc.repository.TownshipRepo;

@Repository
@Profile("client")
public class TownshipRepoClient implements TownshipRepo{

	private RowMapper<TownshipDto> rowMapper = new DataClassRowMapper<>(TownshipDto.class);
	
	@Value("${app.sql.township-select}")
	private String select;
	
	@Autowired
	private JdbcClient client;

	@Override
	public List<TownshipDto> search(Integer divisionId, Integer districtId, String name) {
		
		var sql = new StringBuffer(select).append(" where 1 = 1");
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
		
		return client.sql(sql.toString())
				.params(params)
				.query(rowMapper).list();
	}

	@Override
	public Optional<TownshipDto> findById(int id) {
		return client.sql("%s where ts.id = :id".formatted(select)).params(Map.of("id", id)).query(rowMapper).optional();
	}
}
