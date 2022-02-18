package com.screcruiting.dao;

import com.screcruiting.demo.entity.Resume;

public interface ResumeDAO {

	void saveResume(Resume resume);
	Iterable<Resume> listResumes();
	void deleteResume(int id);
	Resume getResumeByID(int id);
	
	
}
