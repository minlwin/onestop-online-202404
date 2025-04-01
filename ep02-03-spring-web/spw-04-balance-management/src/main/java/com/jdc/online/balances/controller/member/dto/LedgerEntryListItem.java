package com.jdc.online.balances.controller.member.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.LedgerEntry;
import com.jdc.online.balances.model.entity.LedgerEntry_;
import com.jdc.online.balances.model.entity.Ledger_;
import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record LedgerEntryListItem(
		String code,
		LocalDateTime issueAt,
		String ledgerName,
		String particular,
		BigDecimal amount) {
	
	public LedgerEntryListItem(
			LedgerEntryPk id,
			LocalDateTime issueAt,
			String ledgerName,
			String particular,
			BigDecimal amount) {
		this(id.getCode(), issueAt, ledgerName, particular, amount);
	}

	public static void select(CriteriaQuery<LedgerEntryListItem> cq, Root<LedgerEntry> root) {
		cq.multiselect(
			root.get(LedgerEntry_.id),
			root.get(LedgerEntry_.issueAt),
			root.get(LedgerEntry_.ledger).get(Ledger_.name),
			root.get(LedgerEntry_.particular),
			root.get(LedgerEntry_.amount)
		);
	}

}
