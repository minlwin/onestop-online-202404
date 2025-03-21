package com.jdc.online.balances.controller.management.dto;

import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.Member;
import com.jdc.online.balances.model.entity.MemberActivity_;
import com.jdc.online.balances.model.entity.Member_;
import com.jdc.online.balances.model.entity.consts.MemberStatus;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record MemberListItem(
		long id,
		String name,
		LocalDateTime registeredAt,
		LocalDateTime lastLoginAt,
		MemberStatus status,
		LocalDateTime changedAt,
		String remark) {

	public static void select(CriteriaQuery<MemberListItem> cq, Root<Member> root) {
		cq.multiselect(
			root.get(Member_.id),
			root.get(Member_.name),
			root.get(Member_.activity).get(MemberActivity_.registeredAt),
			root.get(Member_.activity).get(MemberActivity_.lastAccessAt),
			root.get(Member_.activity).get(MemberActivity_.status),
			root.get(Member_.activity).get(MemberActivity_.updatedAt),
			root.get(Member_.activity).get(MemberActivity_.statusChangeReason)
		);
	}

}
