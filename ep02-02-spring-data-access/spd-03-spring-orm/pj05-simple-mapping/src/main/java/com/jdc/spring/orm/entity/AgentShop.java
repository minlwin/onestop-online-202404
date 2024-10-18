package com.jdc.spring.orm.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "AGENT_SHOP")
public class AgentShop {

	@Id
	@Column(name = "short_code")
	private String shortCode;
	
	@Column(name = "owner_name")
	private String ownerName;
	
	private String phone;
	
	@Column(name = "shop_name")
	private String shopName;
	
	@Column(name = "established_date")
	private LocalDate startDate;
	
	@Column(name = "open_hour")
	private String openHour;

	@Column(name = "close_hour")
	private String closeHour;
	
	private double lat;
	private double lon;
}
