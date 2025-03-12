package com.jdc.online.balances.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.embeddables.LedgerEntryPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class LedgerEntry extends AbstractEntity {

	@EmbeddedId
	private LedgerEntryPk id;

	@ManyToOne(optional = false)
	private Ledger ledger;

	@Column(nullable = false)
	private BigDecimal lastAmount;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(nullable = false)
	private String particular;

	@Column(nullable = false)
	private LocalDateTime issueAt;

}