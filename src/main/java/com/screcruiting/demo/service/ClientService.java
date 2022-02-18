package com.screcruiting.demo.service;


import org.springframework.stereotype.Service;

import com.screcruiting.demo.entity.Client;

@Service
public interface ClientService {

	void saveClient(String name, String address, String contactInfo);
	Iterable<Client> listAllClient();
	void deleteClient(int id);
	Client getClientById(int id);
	String updateClient(int id, String name, String address, String contactInfo);
	
}

