package com.jdc.online.balances.model.entity;

import com.jdc.online.balances.model.entity.consts.AccessStatus;
import com.jdc.online.balances.model.entity.consts.AccessType;
import com.jdc.online.balances.model.entity.embeddables.AccessHistoryPk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class AccessHistory {

	@EmbeddedId
	private AccessHistoryPk id;

	@Column(nullable = false)
	private AccessType type;

	private AccessStatus status;

	private String remark;

}