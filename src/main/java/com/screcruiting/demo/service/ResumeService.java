package com.screcruiting.demo.service;

import com.screcruiting.demo.entity.Resume;

public interface ResumeService {
	
	void saveResume(String type, String content);
	Iterable<Resume> listAllResume();
	void deleteResume(int id);
	Resume getResumeById(int id);
	String updateResume(int id, String type, String content);

}
