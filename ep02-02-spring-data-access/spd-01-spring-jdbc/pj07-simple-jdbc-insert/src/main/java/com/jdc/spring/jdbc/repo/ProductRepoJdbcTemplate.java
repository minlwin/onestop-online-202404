package com.jdc.spring.jdbc.repo;

import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.jdc.spring.jdbc.domain.ProductDetails;
import com.jdc.spring.jdbc.domain.ProductForm;

@Repository
@Profile("jdbcTemplate")
public class ProductRepoJdbcTemplate implements ProductRepo {
	
	private static final String INSERT_SQL = """
			insert into product (name, category, image, price) 
			values (?, ?, ?, ?)""";
	
	private JdbcTemplate template;
	private RowMapper<ProductDetails> rowMapper;
	
	public ProductRepoJdbcTemplate(DataSource dataSource) {
		rowMapper = new DataClassRowMapper<>(ProductDetails.class);
		template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int create(ProductForm form) {
		
		var keyholder = new GeneratedKeyHolder();
		
		template.update(conn -> {
			var stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, form.name());
			stmt.setString(2, form.category());
			stmt.setString(3, form.image());
			stmt.setInt(4, form.price());
			return stmt;
		}, keyholder);
		
		return keyholder.getKey().intValue();
	}

	@Override
	public ProductDetails findById(int id) {
		return template.query("select * from product where id = ?", 
				rowMapper, id).stream().findAny().orElse(null);
	}

}
