package com.jdc.spring.demo.listener;

import java.time.LocalDateTime;

import com.jdc.spring.demo.entity.AbstractEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AccessTimeListener {

	@PrePersist
	public void setCreation(Object entity) {
		if(entity instanceof AbstractEntity e) {
			e.setCreatedAt(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void setModification(Object entity) {
		if(entity instanceof AbstractEntity e) {
			e.setUpdatedAt(LocalDateTime.now());
		}
	}

}
