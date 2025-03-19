package com.jdc.online.balances.controller.member.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.jdc.online.balances.model.entity.AccessHistory;
import com.jdc.online.balances.model.entity.AccessHistory_;
import com.jdc.online.balances.model.entity.consts.AccessStatus;
import com.jdc.online.balances.model.entity.consts.AccessType;
import com.jdc.online.balances.model.entity.embeddables.AccessHistoryPk_;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record AccessHistoryListItem(
		String member,
		Instant accessAt,
		AccessType type,
		AccessStatus status,
		String remark) {
	
	public LocalDateTime getAccessAtLocal() {
		return accessAt.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static void select(CriteriaQuery<AccessHistoryListItem> cq, Root<AccessHistory> root) {
		cq.multiselect(
			root.get(AccessHistory_.id).get(AccessHistoryPk_.username),
			root.get(AccessHistory_.id).get(AccessHistoryPk_.accessAt),
			root.get(AccessHistory_.type),
			root.get(AccessHistory_.status),
			root.get(AccessHistory_.remark)
		);
	}

}
