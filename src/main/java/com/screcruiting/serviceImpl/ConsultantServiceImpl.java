package com.screcruiting.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import com.screcruiting.dao.ConsultantDAO;
import com.screcruiting.dao.VendorDAO;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.service.ConsultantService;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	ConsultantDAO consultantDAO;
	@Autowired
	VendorDAO vendorDAO;

	@Override
	public void add(String name, String address, String contactInfo) {

		Consultant newConsultant = new Consultant();
		newConsultant.setName(name);
		newConsultant.setAddress(address);
		newConsultant.setContactInfo(contactInfo);
		consultantDAO.saveOrUpdateConsultant(newConsultant);

	}

	@Override
	public Iterable<Consultant> listAllConsultant() {
		return consultantDAO.listAllConsultant();
	}

	@Override
	public void deleteConsultant(int id) {
		consultantDAO.deleteConsultant(id);

	}

	@Override
	public Consultant getConsultantById(int id) {
		return consultantDAO.getConsultantById(id);
	}

	@Override
	public String updateConsultant(int id, String name, String address, String contactInfo) {
		try {
			Consultant consultant = consultantDAO.getConsultantById(id);
			consultant.setName(name);
			consultant.setAddress(address);
			consultant.setContactInfo(contactInfo);
			consultantDAO.saveOrUpdateConsultant(consultant);
			return "Consultant " + id + " Updated";
		} catch (Exception e) {

			e.printStackTrace();
			return "Consultant Not updated!";
		}
	}

	@Override
	public Iterable<Consultant> getConsultantListByVendorId(int id) {
		Set<Consultant> consultantList = vendorDAO.getVendorByID(id).getConsultants();

		// Set seems to give issues. let's use arraylist. Let's attempt to get it
		// working
		// via brute force until we can refine it.
		Iterator<Consultant> iter = consultantList.iterator();
		ArrayList<Consultant> myList = new ArrayList<Consultant>();

		while (iter.hasNext()) {
			myList.add(iter.next());
		}

		return () -> myList.iterator();
	}

	@Override
	public Iterable<Resume> getResumeListByConsultantId(int id) {
		List<Resume> resumeList = consultantDAO.getConsultantById(id).getResumes();

		// Set seems to give issues. let's use arraylist. Let's attempt to get it
		// working
		// via brute force until we can refine it.
		Iterator<Resume> iter = resumeList.iterator();
		ArrayList<Resume> myList = new ArrayList<Resume>();

		while (iter.hasNext()) {
			myList.add(iter.next());
		}

		return () -> myList.iterator();
	}

}
