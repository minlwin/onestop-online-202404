package com.jdc.online.balances.controller.member.dto;

import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.consts.AccessStatus;
import com.jdc.online.balances.model.entity.consts.AccessType;

public record AccessHistoryListItem(
		String member,
		LocalDateTime accessAt,
		AccessType type,
		AccessStatus status,
		String remark) {

}
