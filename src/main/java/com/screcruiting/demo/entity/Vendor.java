package com.screcruiting.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Vendor")
public class Vendor implements  Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "VENDOR_ID")
	private int id;

	//First name, last name? Let's keep it simple for now as whatever they want..
	@Column(name = "NAME")
	private String name;

	//Should we include an Address class? We can keep this as a string for now.
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CCONTACT_INFO")
	private String contactInfo;
	
	@JsonIgnore
	@ManyToMany(targetEntity= Client.class, fetch = FetchType.LAZY)
	@JoinTable(name="vendor_client",
	joinColumns=@JoinColumn(name="vendor_id"), 
	inverseJoinColumns=@JoinColumn(name="client_id"))
	private Set<Client> clients;
	
	@JsonIgnore
	@ManyToMany(targetEntity= Consultant.class,  fetch = FetchType.LAZY)
	@JoinTable(name="vendor_consultant",
	joinColumns=@JoinColumn(name="vendor_id"), 
	inverseJoinColumns=@JoinColumn(name="consultant_id"))
	private Set<Consultant> consultants;

	@JsonIgnore
	@OneToMany(mappedBy="vendor", fetch = FetchType.LAZY)
	private Set<ResumeSubmission> resumeSubmissions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public Set<Client> getClients() {
		return clients;
	}

	@JsonIgnore
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@JsonIgnore
	public Set<Consultant> getConsultants() {
		return consultants;
	}

	@JsonIgnore
	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}

	@JsonIgnore
	public Set<ResumeSubmission> getResumeSubmissions() {
		return resumeSubmissions;
	}

	@JsonIgnore
	public void setResumeSubmissions(Set<ResumeSubmission> resumeSubmissions) {
		this.resumeSubmissions = resumeSubmissions;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	

}
