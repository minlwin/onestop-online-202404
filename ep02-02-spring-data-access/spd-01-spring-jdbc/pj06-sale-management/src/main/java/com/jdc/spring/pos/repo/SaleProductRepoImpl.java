package com.jdc.spring.pos.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdc.spring.pos.domain.input.SaleItem;
import com.jdc.spring.pos.domain.output.SaleDetailsItem;

@Repository
public class SaleProductRepoImpl implements SaleProductRepo{

	@Value("${sql.sale.product.select}")
	private String selectSql;
	
	@Value("${sql.sale.product.insert}")
	private String insertSql;
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	private RowMapper<SaleDetailsItem> rowMapper = new DataClassRowMapper<>(SaleDetailsItem.class);
	
	@Override
	public void creae(int saleId, SaleItem item) {
		item.setSaleId(saleId);
		template.update(insertSql, new BeanPropertySqlParameterSource(item));
	}

	@Override
	public List<SaleDetailsItem> findBySaleId(int id) {
		return template.query(selectSql, Map.of("saleId", id), rowMapper);
	}

}
