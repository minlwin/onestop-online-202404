package com.jdc.spring.jpa.repo;

import java.util.List;

import com.jdc.spring.jpa.dto.input.CustomerSearch;
import com.jdc.spring.jpa.dto.output.CustomerDto;

public interface CustomerRepoCustom {

	List<CustomerDto> search(CustomerSearch search);

}
