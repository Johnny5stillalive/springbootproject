package com.screcruiting.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ClientDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.repository.ClientRepository;

@Service
@ComponentScan(basePackages="com.screcruiting")
public class ClientDAOImpl implements ClientDAO{

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void saveOrUpdateClient(Client client) {
		System.out.println("Client Saved or Updated.");
		clientRepository.save(client);
		
	}


	@Override
	public Iterable<Client> listAllClient() {
		return clientRepository.findAll();
	}


	@Override
	public void deleteClient(int id) {
		clientRepository.deleteById(id);
		
	}


	
	@Override
	public Client getClientByID(int id) {
		try {
			return clientRepository.findById(id).get();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}


	





}
