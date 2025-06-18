package com.jdc.online.rest.hello;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloRestApi {

	@GetMapping
	List<String> hello() {
		return List.of(
			"Hello from My First REST Application",
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
		);
	}
	
	@PostMapping
	ApiResponse hello(@RequestBody ApiRequest request) {
		System.out.println(request);
		return new ApiResponse(
				"Hello %s!".formatted(request.name()), 
				LocalDateTime.now());
	}
}
