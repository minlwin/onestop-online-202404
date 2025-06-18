package com.jdc.online.location.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.online.location.model.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

}
