package com.screcruiting.serviceImpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ClientDAO;
import com.screcruiting.dao.ConsultantDAO;
import com.screcruiting.dao.VendorDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.service.VendorService;


@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorDAO vendorDAO;
	
	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	ConsultantDAO consultantDAO;

	@Override
	public void add(String name, String address, String contactInfo) {
		Vendor newVendor = new Vendor();
		 newVendor.setName(name);
		 newVendor.setAddress(address);
		 newVendor.setContactInfo(contactInfo);
		 vendorDAO.saveorUpdateVendor(newVendor);
		
	}

	
	 
	
	@Override
	public Iterable<Vendor> listAllVendor() {
	
		return vendorDAO.listAllVendor();
	}

	@Override
	public void deleteVendor(int id) {
		vendorDAO.deleteVendor(id);
		
	}


	@Override
	public Vendor getVendorById(int id) {
		return vendorDAO.getVendorByID(id);
	}




	@Override
	public String updateVendor(int id, String name, String address, String contactInfo) {
		try {
			Vendor vendor = vendorDAO.getVendorByID(id);
			vendor.setName(name);
			vendor.setAddress(address);
			vendor.setContactInfo(contactInfo);
			vendorDAO.saveorUpdateVendor(vendor);
			return "Vendor " + id + " Updated";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Vendor Not updated!";
		}
	}




	@Override
	public Iterable<Vendor> getVendorListByClientId(int id) {
//		Set<Client> clientList = vendorDAO.getVendorByID(id).getClients();
		Iterable<Vendor> vendorList = listAllVendor();
		ArrayList<Vendor> myList = new ArrayList<Vendor>();
		
		for(Vendor vendor : vendorList) {
			Iterable<Client> vendorsClientList = vendor.getClients();
			for(Client vendorsClient : vendorsClientList) {
				if(vendorsClient.getId() == id) {
					myList.add(vendor);
				}
			}
		}
		return myList;
//		
	}




	@Override
	public Iterable<Vendor> getVendorListByConsultantId(int id) {
		Iterable<Vendor> vendorList = listAllVendor();
		ArrayList<Vendor> myList = new ArrayList<Vendor>();
		
		for(Vendor vendor : vendorList) {
			Iterable<Consultant> vendorsConsultantList = vendor.getConsultants();
			for(Consultant vendorsConsultant : vendorsConsultantList) {
				if(vendorsConsultant.getId() == id) {
					myList.add(vendor);
				}
			}
		}
		return myList;
	}




	@Override
	public void addClientToVendorRelationship(int clientID, int vendorID) {
		Vendor tempVendor = vendorDAO.getVendorByID(vendorID);
		Set<Client> clientList = tempVendor.getClients();
		clientList.add(clientDAO.getClientByID(clientID));
		tempVendor.setClients(clientList);
		vendorDAO.saveorUpdateVendor(tempVendor);
	}

	
	
}
