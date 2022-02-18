package com.screcruiting.dao;

import com.screcruiting.demo.entity.Resume;

public interface ResumeSubmissionDOA {

	void saveResumeSubmission(Resume resume);
	Iterable<Resume> listResumeSubmissions();
	void deleteResumeSubmission(int id);
	Resume getResumeSumissionByID(int id);
	
}
