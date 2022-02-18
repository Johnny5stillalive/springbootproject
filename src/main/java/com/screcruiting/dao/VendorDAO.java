package com.screcruiting.dao;

import com.screcruiting.demo.entity.Vendor;

public interface VendorDAO {

	void saveorUpdateVendor(Vendor vendor);
	Iterable<Vendor> listAllVendor();
	void deleteVendor(int id);
	Vendor getVendorByID(int id);
	
}
