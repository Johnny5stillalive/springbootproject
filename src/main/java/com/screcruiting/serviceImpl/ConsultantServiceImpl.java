package com.screcruiting.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ConsultantDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.service.ConsultantService;


@Service
public class ConsultantServiceImpl implements ConsultantService{
	
	@Autowired
	ConsultantDAO consultantDAO;

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

	

	
}
