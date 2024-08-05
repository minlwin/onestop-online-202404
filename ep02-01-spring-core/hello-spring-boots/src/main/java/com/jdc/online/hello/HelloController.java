package com.jdc.online.hello;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

	@GetMapping
	List<String> index() {
		return Arrays.asList(DayOfWeek.values())
				.stream()
				.map(day -> "Hello %s".formatted(day))
				.toList();
	}
}
