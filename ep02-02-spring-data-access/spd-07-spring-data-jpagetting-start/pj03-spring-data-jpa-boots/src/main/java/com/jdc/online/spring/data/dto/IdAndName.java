package com.jdc.online.spring.data.dto;

import org.springframework.beans.factory.annotation.Value;

public interface IdAndName {

	int getId();
	String getName();
	
	@Value("#{target.id + ' ' + target.name}")
	String getLongName();
}
