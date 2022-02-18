package com.screcruiting.demo.service;


import org.springframework.stereotype.Service;

import com.screcruiting.demo.entity.Vendor;

@Service
public interface VendorService {

	void add(String name, String address, String contactInfo);
	Iterable<Vendor> listAllVendor();
	void deleteVendor(int id);
	Vendor getVendorById(int id);
	String updateVendor(int id, String name, String address, String contactInfo);
}
