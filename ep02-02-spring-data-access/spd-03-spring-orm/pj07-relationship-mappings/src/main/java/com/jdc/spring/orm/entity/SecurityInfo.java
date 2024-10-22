package com.jdc.spring.orm.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class SecurityInfo {

	@Column(nullable = false)
	private LocalDateTime createAt;

	private LocalDateTime updateAt;
	
	@Column(nullable = false)
	private String createBy;
	
	private String updateBy;
}
