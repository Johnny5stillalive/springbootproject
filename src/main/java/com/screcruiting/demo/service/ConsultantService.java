package com.screcruiting.demo.service;

import org.springframework.stereotype.Service;

import com.screcruiting.demo.entity.Consultant;


@Service
public interface ConsultantService {

	void add(String name, String address, String contactInfo);
	Iterable<Consultant> listAllConsultant();
	void deleteConsultant(int id);
	Consultant getConsultantById(int id);
	String updateConsultant(int id, String name, String address, String contactInfo);
}
