package com.jdc.online.balances.model.entity;

import java.util.List;

import com.jdc.online.balances.model.entity.consts.BalanceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Ledger extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private Member member;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BalanceType type;

	private boolean deleted;
	
	@OneToMany(mappedBy = "ledger")
	private List<LedgerEntry> entry;

}