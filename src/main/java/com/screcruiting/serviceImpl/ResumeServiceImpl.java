package com.screcruiting.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ResumeDAO;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDAO resumeDAO;
	
	@Override
	public void saveResume(Consultant consultant, String type, String content) {
		Resume newResume = new Resume();
		newResume.setConsultant(consultant);
		newResume.setType(type);
		newResume.setContent(content);
		newResume.setConsultantIntID(consultant.getId());
		resumeDAO.saveOrUpdateResume(newResume);
		
	}

	@Override
	public Iterable<Resume> listAllResume() {
		return resumeDAO.listAllResume();
	}

	@Override
	public void deleteResume(int id) {
		resumeDAO.deleteResume(id);
		
	}

	@Override
	public Resume getResumeById(int id) {
		if(resumeDAO.getResumeByID(id) != null) {
			return resumeDAO.getResumeByID(id);
		}else {
			return null;
		}
		
		
	}


	@Override
	public String updateResume(int id, String type, String content) {
		
		try {
			Resume resume = resumeDAO.getResumeByID(id);
			resume.setType(type);
			resume.setContent(content);
				resumeDAO.saveOrUpdateResume(resume);
				return "Resume " + id + " Updated";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Resume Not updated!";
		}
		
		
		
		
	}

	
	

}
