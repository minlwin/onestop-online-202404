package com.jdc.online.balances.model.entity.embeddables;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LedgerEntrySeqPk {

	private long memberId;
	private LocalDate issueDate;

}
