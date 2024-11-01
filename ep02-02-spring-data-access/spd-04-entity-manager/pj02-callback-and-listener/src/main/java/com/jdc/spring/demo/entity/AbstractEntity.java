package com.jdc.spring.demo.entity;

import java.time.LocalDateTime;

import com.jdc.spring.demo.listener.AccessTimeListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(value = AccessTimeListener.class)
public abstract class AbstractEntity {

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
