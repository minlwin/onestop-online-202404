package com.jdc.online.balances.controller.management.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.consts.Gender;

public record MemberDetails(
		long id,
		String name,
		LocalDate dateOfBirth,
		Gender gender,
		String phone, 
		String email,
		String address,
		String township,
		String region,
		boolean status,
		LocalDateTime registeredAt,
		LocalDateTime lastAccessAt
		) {

}
