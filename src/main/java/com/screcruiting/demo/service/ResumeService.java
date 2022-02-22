package com.screcruiting.demo.service;

import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Resume;

public interface ResumeService {
	
	void saveResume(Consultant consultant, String type, String content);
	Iterable<Resume> listAllResume();
	void deleteResume(int id);
	Resume getResumeById(int id);
	String updateResume(int id, String type, String content);

}
