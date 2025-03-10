package com.jdc.online.balances.controller.management.dto;

import java.time.LocalDateTime;

public record MemberItem(
		long id,
		String name,
		LocalDateTime registeredAt,
		LocalDateTime lastLoginAt,
		boolean status,
		LocalDateTime changedAt,
		String remark) {

}
