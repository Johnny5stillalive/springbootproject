package com.screcruiting.dao;


import com.screcruiting.demo.entity.Client;



public interface ClientDAO {

	void saveOrUpdateClient(Client client);
	Iterable<Client> listAllClient();
	void deleteClient(int id);
	Client getClientByID(int id);
	
}
