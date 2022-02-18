package com.screcruiting.daoImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.VendorDAO;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.repository.VendorRepository;

@Service
public class VendorDAOImpl implements VendorDAO {

	@Autowired
	private VendorRepository vendorRepository;
	
	@Override
	public void saveorUpdateVendor(Vendor vendor) { 
		vendorRepository.save(vendor);
		
	}


	@Override
	public Iterable<Vendor> listAllVendor() {
		return vendorRepository.findAll();	
	}


	@Override
	public void deleteVendor(int id) {
		vendorRepository.deleteById(id);
		
	}



	@Override
	public Vendor getVendorByID(int id) {
		return vendorRepository.findById(id).get();
	}


	
}
