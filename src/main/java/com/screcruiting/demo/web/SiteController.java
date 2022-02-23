package com.screcruiting.demo.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.screcruiting.demo.entity.Client;
import com.screcruiting.demo.entity.Consultant;
import com.screcruiting.demo.entity.Resume;
import com.screcruiting.demo.entity.ResumeSubmission;
import com.screcruiting.demo.entity.Vendor;
import com.screcruiting.demo.service.ClientService;
import com.screcruiting.demo.service.ConsultantService;
import com.screcruiting.demo.service.ResumeService;
import com.screcruiting.demo.service.ResumeSubmissionService;
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

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private ResumeSubmissionService resumeSubmissionService;

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

	@GetMapping(path = "/addClient")
	public String addClientPage() {
		return "addClient.html";
	}

	@GetMapping(path = "/addVendor")
	public String addVendorPage() {
		return "addVendor.html";
	}

	@GetMapping(path = "/addConsultant")
	public String addConsultantPage() {
		return "addConsultant.html";
	}

	@GetMapping(path = "/consultantResumeList/{consultantID}")
	public String consultantResumeList() {
		return "consultantResumeList.html";
	}

	@GetMapping(path = "/consultantResumeList/addResume/{consultantID}")
	public String addResume() {
		return "addResume.html";
	}

	@GetMapping(path = "/consultantResumeList/addSubmission/{resumeId}")
	public String addResumeSubmission() {
		return "addSubmission.html";
	}
	
	@GetMapping(path = "/updateClient/{clientId}")
	public String updateClient() {
		return "updateClient.html";
	}
	
	@GetMapping(path = "/updateConsultant/{consultantId}")
	public String updateConsultant() {
		return "updateConsultant.html";
	}
	
	@GetMapping(path = "/updateVendor/{vendorId}")
	public String updateVendor() {
		return "updateVendor.html";
	}

	/////////////////////////////////////////////////////////////
	// ------------------------GET LIST------------------------//
	/////////////////////////////////////////////////////////////

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

	@GetMapping(path = "/getResumeList")
	public @ResponseBody Iterable<Resume> getAllResumes() {
		// This returns a JSON or XML with the Clients
		return resumeService.listAllResume();
	}

	/////////////////////////////////////////////////////////////
	// ------------------------ADD NEW-------------------------//
	/////////////////////////////////////////////////////////////

	@PostMapping(path = "/addNewClient")
	public @ResponseBody String addNewClient(@RequestParam String name, @RequestParam String address,
			@RequestParam String contactInfo) {
		System.out.println(name + address + contactInfo);
		clientService.saveClient(name, address, contactInfo);
		return "New Client Saved";
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

	@PostMapping(path = "/addResume")
	public @ResponseBody String addNewResume(@RequestParam int consultantID, @RequestParam String type,
			@RequestParam String content) {
		Consultant consultant = consultantService.getConsultantById(consultantID);

		resumeService.saveResume(consultant, type, content);
		return "Resume Saved";
	}

	/////////////////////////////////////////////////////////////
	// -------------------------DELETE-------------------------//
	/////////////////////////////////////////////////////////////

	@PostMapping(path = "/deleteClient")
	public @ResponseBody String deleteClient(@RequestParam int id) {
		// TODO make sure the consultant exists before trying to delete
		clientService.deleteClient(id);
		return "Client " + id + " deleted.";
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

	@PostMapping(path = "/deleteResume")
	public @ResponseBody String deleteResume(@RequestParam int id) {
		// TODO make sure the Resume exists before trying to delete
		resumeService.deleteResume(id);
		return "Resume " + id + " deleted.";
	}

	/////////////////////////////////////////////////////////////
	// -----------------------GET BY ID------------------------//
	/////////////////////////////////////////////////////////////

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

	@GetMapping(path = "/getResumeById")
	public @ResponseBody Resume getResumeByID(@RequestParam int id) {
		return resumeService.getResumeById(id);

	}

	/////////////////////////////////////////////////////////////
	// -------------------------UPDATE-------------------------//
	/////////////////////////////////////////////////////////////

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

	@PostMapping(path = "/updateResume")
	public @ResponseBody String updateResume(@RequestParam int id, @RequestParam String type,
			@RequestParam String content) {

		return resumeService.updateResume(id, type, content);

	}

	/////////////////////////////////////////////////////////////
	// ----------------RESUMESUBMISSION METHODS----------------//
	/////////////////////////////////////////////////////////////
	@GetMapping(path = "/getResumeSubmissionList")
	public @ResponseBody Iterable<ResumeSubmission> getAllResumeSubmissions() {
		return resumeSubmissionService.listAllResumeSubmission();
	}

	@PostMapping(path = "/addResumeSubmission")
	public @ResponseBody String addNewResumeSubmission(@RequestParam int resumeID, @RequestParam String date,
			@RequestParam int vendorID, @RequestParam int clientID) {
		Date sqlDate = Date.valueOf(date);
		Resume resume = resumeService.getResumeById(resumeID);
		Vendor vendor = vendorService.getVendorById(vendorID);
		Client client = clientService.getClientById(clientID);

		resumeSubmissionService.saveResumeSubmission(resume, sqlDate, vendor, client);
		return "Resume Submission Saved";
	}

	@GetMapping(path = "/getResumeSubmissionById")
	public @ResponseBody ResumeSubmission getResumeSubmissionByID(@RequestParam int id) {
		return resumeSubmissionService.getResumeSubmissionById(id);

	}

	@PostMapping(path = "/updateResumeSubmission")
	public @ResponseBody String updateResumeSubmission(@RequestParam int id, @RequestParam Resume resume,
			@RequestParam Vendor vendor, @RequestParam Client client) {

		return resumeSubmissionService.updateResumeSubmission(id, resume, vendor, client);

	}

	@PostMapping(path = "/deleteResumeSubmission")
	public @ResponseBody String deleteResumeSubmission(@RequestParam int id) {
		// TODO make sure the ResumeSubmission exists before trying to delete
		resumeSubmissionService.deleteResumeSubmission(id);
		return "ResumeSubmission " + id + " deleted.";
	}

	/////////////////////////////////////////////////////////////
	// -------------------SPECIALIZED METHODS------------------//
	/////////////////////////////////////////////////////////////

	@GetMapping(path = "/getClientByResumeSubmissionId")
	public @ResponseBody Client getClientByResumeSubmissionId(@RequestParam int id) {
		return clientService.getClientByResumeSubmissionId(id);
	} // get list of clients with vendor

	@GetMapping(path = "/getClientListbyResumeId")
	public @ResponseBody Iterable<Client> getClientListByResumeId(@RequestParam int id) {
		return clientService.getClientListByResumeId(id);
	}

	@GetMapping(path = "/getClientListByVendorId")
	public @ResponseBody Iterable<Client> getClientListByVendorId(@RequestParam int id) {
		return clientService.getClientListByVendorId(id);
	}

	// get list of consultants with vendor ID
	@GetMapping(path = "/getConsultantListByVendorId")
	public @ResponseBody Iterable<Consultant> getConsultantListByVendorId(@RequestParam int id) {
		return consultantService.getConsultantListByVendorId(id);
	}

	@GetMapping(path = "/getAllClientByResumeID")
	public @ResponseBody Iterable<Client> getAllClientByResumeId(@RequestParam int id) {
		return clientService.listAllClientByResumeId(id);
	}

	@GetMapping(path = "/getResumeListByConsultantId")
	public @ResponseBody Iterable<Resume> getResumeListByConsultantId(@RequestParam int id) {
		return consultantService.getResumeListByConsultantId(id);
	}

	
	@GetMapping(path = "/getResumeSubmissionListByResumeId")
	public @ResponseBody Iterable<ResumeSubmission> getResumeSubmissionListByResumeId(@RequestParam int id) {
		return resumeSubmissionService.getResumeSubmissionListByResumeId(id);
	}
}
