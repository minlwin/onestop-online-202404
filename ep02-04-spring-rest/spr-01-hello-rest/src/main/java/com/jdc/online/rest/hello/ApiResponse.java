package com.jdc.online.rest.hello;

import java.time.LocalDateTime;

public record ApiResponse(
		String message,
		LocalDateTime sendAt
		){

}
