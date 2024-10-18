package com.jdc.spring.orm;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.spring.orm.entity.AgentShop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class AgentShopCreationDemo {

	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	void create() {
		
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
		
		em.persist(shop);
	}
}
