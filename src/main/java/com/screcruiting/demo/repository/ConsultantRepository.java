package com.screcruiting.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.screcruiting.demo.entity.Consultant;

@Repository
public interface ConsultantRepository extends CrudRepository<Consultant, Integer>{
	
}
