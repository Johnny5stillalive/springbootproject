package com.screcruiting.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.VendorDAO;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.service.VendorService;


@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	VendorDAO vendorDAO;

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

	
	
}
