package com.screcruiting.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ResumeSubmissionDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.entity.ResumeSubmission;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.service.ResumeSubmissionService;

@Service
public class ResumeSubmissionServiceImpl implements ResumeSubmissionService {

	@Autowired
	private ResumeSubmissionDAO resumeSubmissionDAO;
		
	@Override
	public void saveResumeSubmission(Resume resume, Vendor vendor, Client client) {
		ResumeSubmission newResumeSubmission = new ResumeSubmission();
		newResumeSubmission.setResume(resume);
		newResumeSubmission.setVendor(vendor);
		newResumeSubmission.setClient(client);
		resumeSubmissionDAO.saveOrUpdateResumeSubmission(newResumeSubmission);
		
	}

	@Override
	public Iterable<ResumeSubmission> listAllResumeSubmission() {
		return resumeSubmissionDAO.listAllResumeSubmission();
	}

	@Override
	public void deleteResumeSubmission(int id) {
		resumeSubmissionDAO.deleteResumeSubmission(id);
		
	}

	@Override
	public ResumeSubmission getResumeSubmissionById(int id) {
		if(resumeSubmissionDAO.getResumeSubmissionByID(id) != null) {
			return resumeSubmissionDAO.getResumeSubmissionByID(id);
		}else {
			return null;
		}
		
		
	}


	@Override
	public String updateResumeSubmission(int id, Resume resume, Vendor vendor, Client client) {
		
		try {
			ResumeSubmission resumeSubmission = resumeSubmissionDAO.getResumeSubmissionByID(id);
			resumeSubmission.setResume(resume);
			resumeSubmission.setVendor(vendor);
			resumeSubmission.setClient(client);
				resumeSubmissionDAO.saveOrUpdateResumeSubmission(resumeSubmission);
				return "ResumeSubmission " + id + " Updated";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "ResumeSubmission Not updated!";
		}
		
		
		
		
	}

	
	

}
