package com.jdc.spring.jpa.repo;

import java.util.UUID;

import com.jdc.spring.jpa.base.BaseRepository;
import com.jdc.spring.jpa.entity.Customer;

public interface CustomerRepo extends BaseRepository<Customer, UUID>, CustomerRepoCustom {

}
