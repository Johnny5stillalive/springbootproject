package com.screcruiting.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ResumeSubmissionDAO;
import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.entity.ResumeSubmission;
import com.screcruiting.demo.repository.ResumeRepository;
import com.screcruiting.demo.repository.ResumeSubmissionRepository;

@Service
@ComponentScan(basePackages="com.screcruiting")
public class ResumeSubmissionDAOImpl implements ResumeSubmissionDAO{

	@Autowired
	private ResumeSubmissionRepository resumeSubmissionRepository;

	@Override
	public void saveOrUpdateResumeSubmission(ResumeSubmission resumeSubmission) {
		System.out.println("Resume Submission Saved or Updated.");
		resumeSubmissionRepository.save(resumeSubmission);
	}

	@Override
	public Iterable<ResumeSubmission> listAllResumeSubmission() {
		return resumeSubmissionRepository.findAll();
	}

	@Override
	public void deleteResumeSubmission(int id) {
		resumeSubmissionRepository.deleteById(id);
	}
	
	@Override
	public ResumeSubmission getResumeSubmissionByID(int id) {
		try {
			return resumeSubmissionRepository.findById(id).get();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
		
		
}
