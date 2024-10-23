package com.jdc.spring.orm.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Settlement extends SecurityInfo {

	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(optional = false)
	private Merchant merchant;
	
	@OneToMany(mappedBy = "settlement")
	private List<Invoice> invoice;
	
	@Column(nullable = false)
	private LocalDateTime settleAt;

	@Column(nullable = false)
	private BigDecimal settleAmount;
}
