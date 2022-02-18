package com.screcruiting.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.screcruiting.demo.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

}
