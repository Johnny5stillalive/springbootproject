package com.screcruiting.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.service.ClientService;
import com.screcruiting.demo.service.ConsultantService;
import com.screcruiting.demo.service.VendorService;

@ComponentScan(basePackages = "com.screcruiting")
@Controller
public class SiteController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private ConsultantService consultantService;

	@RequestMapping(path = "/login")
	public String index(@RequestParam String name, @RequestParam String password) {
		return "loginSuccess.html";
	}

	@RequestMapping(path = "/homePage")
	public String homePage() {
		return "homePage.html";
	}

	@RequestMapping(path = "/clientList")
	public String clientList() {
		return "clientList.html";
	}

	@RequestMapping(path = "/vendorList")
	public String vendorList() {
		return "vendorList.html";
	}

	@RequestMapping(path = "/consultantList")
	public String consultantList() {
		return "consultantList.html";
	}
	
	@GetMapping(path="/addClient")
	public String addClientPage() {
		return "addClient.html";
	}
	
	@GetMapping(path="/addVendor")
	public String addVendorPage() {
		return "addVendor.html";
	}
	
	@GetMapping(path="/addConsultant")
	public String addConsultantPage() {
		return "addConsultant.html";
	}

	@GetMapping(path = "/getClientList")
	public @ResponseBody Iterable<Client> getAllClients() {
		// This returns a JSON or XML with the Clients
		return clientService.listAllClient();
	}

	@GetMapping(path = "/getVendorList")
	public @ResponseBody Iterable<Vendor> getAllVendors() {
		// This returns a JSON or XML with the Vendors
		return vendorService.listAllVendor();
	}

	@GetMapping(path = "/getConsultantList")
	public @ResponseBody Iterable<Consultant> getAllConsultants() {
		// This returns a JSON or XML with the Consultants
		return consultantService.listAllConsultant();
	}
	

	@PostMapping(path = "/addNewClient")
	public @ResponseBody String addNewClient(@RequestParam String name, @RequestParam String address,
			@RequestParam String contactInfo) {

		clientService.saveClient(name, address, contactInfo);
		return "Client Saved";
	}

	@PostMapping(path = "/addNewConsultant")
	public @ResponseBody String addNewConsultant(@RequestParam String name, @RequestParam String address,
			@RequestParam String contactInfo) {

		consultantService.add(name, address, contactInfo);
		return "Consultant Saved";
	}

	@PostMapping(path = "/addNewVendor")
	public @ResponseBody String addNewVendor(@RequestParam String name, @RequestParam String address,
			@RequestParam String contactInfo) {

		vendorService.add(name, address, contactInfo);
		return "Vendor Saved";
	}

	@PostMapping(path = "/deleteClient" )
	public @ResponseBody String deleteClient(@RequestBody Client client) {
		// TODO make sure the client exists before trying to delete
		
		clientService.deleteClient(client.getId());
		System.out.println("deleted");
		return "Client " + client.getId() + " deleted.";
	}

	@PostMapping(path = "/deleteConsultant")
	public @ResponseBody String deleteConsultant(@RequestParam int id) {
		// TODO make sure the consultant exists before trying to delete
		consultantService.deleteConsultant(id);
		return "Consultant " + id + " deleted.";
	}

	@PostMapping(path = "/deleteVendor")
	public @ResponseBody String deleteVendor(@RequestParam int id) {
		// TODO make sure the vendor exists before trying to delete
		vendorService.deleteVendor(id);
		return "Vendor " + id + " deleted.";
	}

	// TODO add resume, add resume submission ,
	// get resume list, get resume submissions, get resume by id, get clients by resume
	// get list of clients with vendor
	// get list of consultants with vendor
	
	
	//TODO Get a list of resumes by consultant id
	//TODO Get a list of resumeSubmission for resume ID

	@GetMapping(path = "/getClientById")
	public @ResponseBody Client getClientByID(@RequestParam int id) {
		return clientService.getClientById(id);

	}

	@GetMapping(path = "/getConsultantById")
	public @ResponseBody Consultant getConsultantByID(@RequestParam int id) {
		return consultantService.getConsultantById(id);

	}

	@GetMapping(path = "/getVendorById")
	public @ResponseBody Vendor getVendorByID(@RequestParam int id) {
		return vendorService.getVendorById(id);

	}

	@PostMapping(path = "/updateClient")
	public @ResponseBody String updateClient(@RequestParam int id, @RequestParam String name,
			@RequestParam String address, @RequestParam String contactInfo) {

		return clientService.updateClient(id, name, address, contactInfo);

	}

	@PostMapping(path = "/updateConsultant")
	public @ResponseBody String updateConsultant(@RequestParam int id, @RequestParam String name,
			@RequestParam String address, @RequestParam String contactInfo) {

		return consultantService.updateConsultant(id, name, address, contactInfo);

	}

	@PostMapping(path = "/updateVendor")
	public @ResponseBody String updateVendor(@RequestParam int id, @RequestParam String name,
			@RequestParam String address, @RequestParam String contactInfo) {

		return vendorService.updateVendor(id, name, address, contactInfo);

	}

}
