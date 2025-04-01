package com.jdc.online.balances.model.entity.embeddables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LedgerEntryPk {

	private long memberId;
	private LocalDate issueDate;
	private int seqNumber;
	
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyyMMdd");
	
	public String getCode() {
		return "%s%03d".formatted(issueDate.format(DF));
	}

	public static LedgerEntryPk parse(long memberId, String id) {
		var pk = new LedgerEntryPk();
		
		var issuseDate = LocalDate.parse(id.substring(0,  8), DF);
		var seqNumber = Integer.parseInt(id.substring(9));
		
		pk.setMemberId(memberId);
		pk.setIssueDate(issuseDate);
		pk.setSeqNumber(seqNumber);
		
		return pk;
	}

}