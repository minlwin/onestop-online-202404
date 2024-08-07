package com.jdc.spring.events;

import java.time.LocalDateTime;

public record MyEvent(String message, LocalDateTime publishAt) {

	public MyEvent(String message) {
		this(message, LocalDateTime.now());
	}
}
