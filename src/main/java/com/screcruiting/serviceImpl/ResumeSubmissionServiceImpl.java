package com.screcruiting.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;						   

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
	public void saveResumeSubmission(Resume resume, Date date, Vendor vendor, Client client) {
		ResumeSubmission newResumeSubmission = new ResumeSubmission();
		newResumeSubmission.setResume(resume);
		newResumeSubmission.setDate(date);
		newResumeSubmission.setVendor(vendor);
		newResumeSubmission.setClient(client);
		newResumeSubmission.setClientName(client.getName());
		newResumeSubmission.setVendorName(vendor.getName());
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

	@Override
	public Iterable<ResumeSubmission> getResumeSubmissionListByResumeId(int id) {

        Iterable<ResumeSubmission> mainIterable = resumeSubmissionDAO.listAllResumeSubmission();
        Iterator<ResumeSubmission> iter = mainIterable.iterator();
        ArrayList<ResumeSubmission> myList = new ArrayList<ResumeSubmission>();
        
        ResumeSubmission tempResumeSubmission;
        while(iter.hasNext())
        {
            tempResumeSubmission = iter.next();
            if(tempResumeSubmission.getResume().getId() == id)
            {
                myList.add(tempResumeSubmission);

            }
        }
     
        return() -> myList.iterator();
	}	  
	
	

}
