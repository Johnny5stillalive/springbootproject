package com.screcruiting.dao;

import com.screcruiting.demo.entity.ResumeSubmission;

public interface ResumeSubmissionDAO {
	
	void saveOrUpdateResumeSubmission(ResumeSubmission resumeSubmission);
	Iterable<ResumeSubmission> listAllResumeSubmission();
	void deleteResumeSubmission(int id);
	ResumeSubmission getResumeSubmissionByID(int id);
	
}
