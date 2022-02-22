package com.screcruiting.dao;

import com.screcruiting.demo.entity.Resume;

public interface ResumeDAO {

	void saveOrUpdateResume(Resume resume);
	Iterable<Resume> listAllResume();
	void deleteResume(int id);
	Resume getResumeByID(int id);
	
	
}
