package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.Ledger;
import com.jdc.online.balances.model.entity.LedgerEntry_;
import com.jdc.online.balances.model.entity.Ledger_;
import com.jdc.online.balances.model.entity.consts.BalanceType;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public record LedgerListItem(
		int id,
		BalanceType type,
		String name,
		boolean status,
		LocalDateTime createdAt,
		LocalDateTime modifiedAt,
		BigDecimal total) {

	public static void select(CriteriaBuilder cb, CriteriaQuery<LedgerListItem> cq, Root<Ledger> root) {
		
		var entry = root.join(Ledger_.entry, JoinType.LEFT);
		
		cq.multiselect(
			root.get(Ledger_.id),
			root.get(Ledger_.type),
			root.get(Ledger_.name),
			root.get(Ledger_.deleted),
			root.get(Ledger_.createdAt),
			root.get(Ledger_.updatedAt),
			cb.sum(entry.get(LedgerEntry_.amount))
		);
		
		cq.groupBy(
			root.get(Ledger_.id),
			root.get(Ledger_.type),
			root.get(Ledger_.name),
			root.get(Ledger_.deleted),
			root.get(Ledger_.createdAt),
			root.get(Ledger_.updatedAt)
		);
	}

}
