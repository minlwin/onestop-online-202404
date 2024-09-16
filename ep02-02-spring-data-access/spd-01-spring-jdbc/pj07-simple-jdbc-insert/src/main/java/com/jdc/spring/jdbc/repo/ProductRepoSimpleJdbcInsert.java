package com.jdc.spring.jdbc.repo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.spring.jdbc.domain.ProductDetails;
import com.jdc.spring.jdbc.domain.ProductForm;

@Repository
@Profile("simpleJdbcInsert")
public class ProductRepoSimpleJdbcInsert implements ProductRepo {
	
	private JdbcTemplate template;
	private SimpleJdbcInsert insert;
	private RowMapper<ProductDetails> rowMapper;
	
	public ProductRepoSimpleJdbcInsert(DataSource dataSource) {
		rowMapper = new DataClassRowMapper<>(ProductDetails.class);
		template = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource)
				.usingGeneratedKeyColumns("id")
				.usingColumns("name", "category", "image", "price");
	}
	
	@Override
	public int create(ProductForm form) {
		return insert.executeAndReturnKey(new SimplePropertySqlParameterSource(form))
				.intValue();
	}

	@Override
	public ProductDetails findById(int id) {
		return template.queryForObject("select * from product where id = ?", 
				rowMapper, id);
	}

}
