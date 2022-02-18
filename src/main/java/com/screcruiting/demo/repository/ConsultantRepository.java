package com.screcruiting.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.screcruiting.demo.entity.Consultant;


public interface ConsultantRepository extends CrudRepository<Consultant, Integer>{
	
}
