package com.jdc.security.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.jwt")
public class JwtTokenProperties {

	private String issuer;
	private int accessLife;
	private int refreshLife;
}
