package com.screcruiting.serviceImpl;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.screcruiting.dao.ClientDAO;
import com.screcruiting.dao.ResumeSubmissionDAO;
import com.screcruiting.dao.VendorDAO;
import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.ResumeSubmission;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private ResumeSubmissionDAO resumeSubmissionDAO;

	@Autowired
	VendorDAO vendorDAO;

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
		if (clientDAO.getClientByID(id) != null) {
			return clientDAO.getClientByID(id);
		} else {
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

	@Override
	public Iterable<Client> listAllClientByResumeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientByResumeSubmissionId(int id) {

		return resumeSubmissionDAO.getResumeSubmissionByID(id).getClient();

	}

	@Override
	public Iterable<Client> getClientListByVendorId(int id) {

		Set<Client> clientList = vendorDAO.getVendorByID(id).getClients();

		return clientList;
		
//		// Set seems to give issues. let's use arraylist. Let's attempt to get it
//		// working
//		// via brute force until we can refine it.
//		Iterator<Client> iter = clientList.iterator();
//		ArrayList<Client> myList = new ArrayList<Client>();
//
//		while (iter.hasNext()) {
//			myList.add(iter.next());
//		}
//
//		return () -> myList.iterator();

	}

	@Override
	public Iterable<Client> getClientListByResumeId(int id) {

		Iterable<ResumeSubmission> mainIterable = resumeSubmissionDAO.listAllResumeSubmission();
		Iterator<ResumeSubmission> iter = mainIterable.iterator();
		ArrayList<Client> myList = new ArrayList<Client>();

		ResumeSubmission tempResumeSubmission;

		// While we still have another submission to check...
		while (iter.hasNext()) {
			tempResumeSubmission = iter.next();
			// we will check for a resumeSubmission that has the given resume id and for a
			// unique client.
			// THIS IS A UNIQUE LINE. I HADN'T REALIZED THIS ISSUE UNTIL NOW.
			if (tempResumeSubmission.getResume().getId() == id && !myList.contains(tempResumeSubmission.getClient())) {
				// And add that client to the return list. There should be no copies.
				myList.add(tempResumeSubmission.getClient());

			}
		}

		return () -> myList.iterator();
	}

}
