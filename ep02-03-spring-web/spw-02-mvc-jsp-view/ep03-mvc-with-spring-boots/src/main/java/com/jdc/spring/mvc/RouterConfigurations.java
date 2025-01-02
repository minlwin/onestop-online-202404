package com.jdc.spring.mvc;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class RouterConfigurations {

	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route()
				.GET("/function", req -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(List.of("Hello Router Function")))
				.build();
	}
}
