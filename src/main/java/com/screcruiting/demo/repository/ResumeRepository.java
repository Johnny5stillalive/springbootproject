package com.screcruiting.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.screcruiting.demo.entity.Resume;



@Repository
public interface ResumeRepository extends CrudRepository<Resume, Integer>{

}
