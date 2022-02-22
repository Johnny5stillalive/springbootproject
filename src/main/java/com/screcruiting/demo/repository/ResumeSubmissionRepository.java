package com.screcruiting.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.screcruiting.demo.entity.ResumeSubmission;



@Repository
public interface ResumeSubmissionRepository extends CrudRepository<ResumeSubmission, Integer>{

}