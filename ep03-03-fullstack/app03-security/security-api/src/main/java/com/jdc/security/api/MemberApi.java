package com.jdc.security.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberApi {

	@GetMapping
	List<String> index() {
		return List.of("Message from Member API.");
	}
}
