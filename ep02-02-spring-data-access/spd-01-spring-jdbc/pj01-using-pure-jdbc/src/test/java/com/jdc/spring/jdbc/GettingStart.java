package com.jdc.spring.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(value = OrderAnnotation.class)
public class GettingStart {
	
	private static final String URL = "jdbc:h2:mem:TestDB";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	static Connection connection;

	// Before All
	@BeforeAll
	static void beforeAll() throws SQLException {
		// Create Connection Object
		connection = DriverManager.getConnection(
				URL, 
				USERNAME, 
				PASSWORD);
		
		// Create Table
		var accountTableDDL = """
				create table ACCOUNT (
				id int GENERATED BY DEFAULT AS IDENTITY,
				name varchar(40) not null,
				phone varchar(12) not null
				);
				""";
		
		try(var statement = connection.createStatement()) {
			statement.execute(accountTableDDL);
		}
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,0911112222,1",
		"Thidar,0911112223,2",
		"Nilar,0911112224,3",
	})
	void test_insert(String name, String phone, int expectedId) {
		
		// Define SQL
		var sql = "insert into ACCOUNT(name, phone) values (?, ?)";
		
		// Prepared Statement
		try(var stmt = connection.prepareStatement(sql, 
				Statement.RETURN_GENERATED_KEYS)) {
			
			// Set Parameter
			stmt.setString(1, name);
			stmt.setString(2, phone);

			// Execute Statement
			stmt.executeUpdate();
			
			// Get Generated Primary Key
			var rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				var pk = rs.getInt(1);
				// Check Result
				assertEquals(expectedId, pk);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	@Order(2)
	void test_select_count() {
		
		var sql = "select count(*) from ACCOUNT";
		
		try(var stmt = connection.prepareStatement(sql)) {
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var count = rs.getLong(1);
				assertEquals(3L, count);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,0911112222,1",
		"Thidar,0911112223,2",
		"Nilar,0911112224,3",
	})
	void test_find_by_id(String name, String phone, int id) {
		
		var sql = "select * from ACCOUNT where id = ?";
		
		try(var stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			if(rs.next()) {
				var nameColumn = rs.getString("name");
				var phoneColumn = rs.getString("phone");
				
				assertEquals(name, nameColumn);
				assertEquals(phone, phoneColumn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// After All
	@AfterAll
	static void afterAll() throws SQLException {
		// Close Connection
		if(null != connection) {
			connection.close();
		}
	}

}