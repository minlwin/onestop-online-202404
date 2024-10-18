package com.jdc.spring.orm;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.spring.orm.entity.AgentShop;
import com.jdc.spring.orm.repo.AgentShopRepo;

@SpringBootTest
public class AgentShopCreationDemo {

	@Autowired
	private AgentShopRepo repo;
	
	@Test
	public void create() {
		
		var shop = new AgentShop();
		shop.setShortCode("SA000001");
		shop.setOwnerName("Thidar Aung");
		shop.setShopName("Thit Sar Store");
		shop.setPhone("0918171716");
		shop.setLat(42.11018181);
		shop.setLon(168.19187777);
		shop.setStartDate(LocalDate.of(2000, 10, 15));
		shop.setOpenHour("8:00");
		shop.setCloseHour("20:00");
		
		repo.create(shop);
	}
}
