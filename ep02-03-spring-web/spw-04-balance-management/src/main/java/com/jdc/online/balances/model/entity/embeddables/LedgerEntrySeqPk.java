package com.jdc.online.balances.model.entity.embeddables;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LedgerEntrySeqPk {

	private long memberId;
	private LocalDate issueDate;

}
