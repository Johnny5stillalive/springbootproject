package com.screcruiting.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ConsultantDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.repository.ConsultantRepository;

@Service
public class ConsultantDAOImpl implements ConsultantDAO {

	@Autowired
	ConsultantRepository consultantRepository;

	@Override
	public void saveOrUpdateConsultant(Consultant consultant) {
		consultantRepository.save(consultant);

	}

	@Override
	public Iterable<Consultant> listAllConsultant() {
		return consultantRepository.findAll();
	}

	@Override
	public void deleteConsultant(int id) {
		consultantRepository.deleteById(id);

	}

	@Override
	public Consultant getConsultantById(int id) {
		return consultantRepository.findById(id).get();
	}

}
