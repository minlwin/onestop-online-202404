package com.jdc.spring.jdbc;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
	
	private RepositoryConfig sql = new RepositoryConfig();

	@Data
	public static class RepositoryConfig {
		private String divisionSelect;
		private String divisionGroupBy;
		private String districtSelect;
		private String districtGroupBy;
		private String townshipSelect;
	}
}
