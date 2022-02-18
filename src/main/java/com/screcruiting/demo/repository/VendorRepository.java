package com.screcruiting.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.screcruiting.demo.entity.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Integer>{

}
