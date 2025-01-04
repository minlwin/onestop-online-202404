package com.jdc.spring.mvc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.mvc.model.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
