package com.jdc.online.balances.controller.management.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberStatusForm {
	@NotNull(message = "Please select status.")
	private Boolean status;
	private String reason;
}
