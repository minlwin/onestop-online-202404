package com.jdc.online.balances.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jdc.online.balances.model.entity.consts.MemberStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class MemberActivity extends AbstractEntity {

	@Id
	private long id;

	@MapsId
	@OneToOne(optional = false)
	private Member member;

	private MemberStatus status;
	private String statusChangeReason;

	private BigDecimal balance;
	
	private LocalDateTime registeredAt;

	private LocalDateTime lastAccessAt;

}