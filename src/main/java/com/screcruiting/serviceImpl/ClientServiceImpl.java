package com.screcruiting.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ClientDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	public void saveClient(String name, String address, String contactInfo) {
		Client newClient = new Client();
		newClient.setName(name);
		newClient.setAddress(address);
		newClient.setContactInfo(contactInfo);
		clientDAO.saveOrUpdateClient(newClient);
		
	}

	@Override
	public Iterable<Client> listAllClient() {
		return clientDAO.listAllClient();
	}

	@Override
	public void deleteClient(int id) {
		clientDAO.deleteClient(id);
		
	}

	@Override
	public Client getClientById(int id) {
		if(clientDAO.getClientByID(id) != null) {
			return clientDAO.getClientByID(id);
		}else {
			return null;
		}
		
	}


	@Override
	public String updateClient(int id, String name, String address, String contactInfo) {
		
		try {
			Client client = clientDAO.getClientByID(id);
			client.setName(name);
			client.setAddress(address);
			client.setContactInfo(contactInfo);
				clientDAO.saveOrUpdateClient(client);
				return "Client " + id + " Updated";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Client Not updated!";
		}
		
		
		
		
	}

	
	

}
