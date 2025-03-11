package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDateTime;

public record MemberProfileDetails(
		long id,
		String name,
		String phone,
		String email,
		String address,
		LocalDateTime registeredAt,
		LocalDateTime lastAccessAt) {

}
