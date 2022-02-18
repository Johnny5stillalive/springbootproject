package com.screcruiting.dao;

import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.entity.ResumeSubmission;

public interface ResumeSubmissionDOA {

	void saveResumeSubmission(ResumeSubmission resumeSubmission);
	Iterable<ResumeSubmission> listResumeSubmissions();
	void deleteResumeSubmission(int id);
	ResumeSubmission getResumeSumissionByID(int id);
	
}
