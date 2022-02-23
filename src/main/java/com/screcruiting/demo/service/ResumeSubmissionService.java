package com.screcruiting.demo.service;

import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.entity.ResumeSubmission;
import com.screcruiting.demo.entity.Vendor;

import java.sql.Date;

import com.screcruiting.demo.entity.Client;

public interface ResumeSubmissionService {
	
	void saveResumeSubmission(Resume resume, Date date, Vendor vendor, Client client);
	Iterable<ResumeSubmission> listAllResumeSubmission();
	void deleteResumeSubmission(int id);
	ResumeSubmission getResumeSubmissionById(int id);
	String updateResumeSubmission(int id, Resume resume, Vendor vendor, Client client);
	Iterable<ResumeSubmission> getResumeSubmissionListByResumeId(int id);
	

}
