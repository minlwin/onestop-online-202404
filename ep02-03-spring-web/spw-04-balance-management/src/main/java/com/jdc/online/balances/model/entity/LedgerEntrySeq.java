package com.jdc.online.balances.model.entity;

import com.jdc.online.balances.model.entity.embeddables.LedgerEntrySeqPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class LedgerEntrySeq {

	@EmbeddedId
	private LedgerEntrySeqPk id;
	
	@Column(nullable = false)
	private int seqNumber;

}