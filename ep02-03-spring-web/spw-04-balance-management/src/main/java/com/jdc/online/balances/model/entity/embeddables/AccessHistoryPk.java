package com.jdc.online.balances.model.entity.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AccessHistoryPk {

	private String username;
	private String accessAt;

}