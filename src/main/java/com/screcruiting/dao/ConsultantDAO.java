package com.screcruiting.dao;


import com.screcruiting.demo.entity.Consultant;


public interface ConsultantDAO {

	void saveOrUpdateConsultant(Consultant client);
	Iterable<Consultant> listAllConsultant();
	void deleteConsultant(int id);
	Consultant getConsultantById(int id);
}
