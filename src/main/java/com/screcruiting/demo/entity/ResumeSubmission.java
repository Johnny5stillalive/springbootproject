package com.screcruiting.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="RESUME_SUBMISSION")
public class ResumeSubmission {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESUME_SUBMISSION_ID")
	private Integer id;
	
	//@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RESUME_ID")
	private Resume resume;
	
	//@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	@Column(name="DATE")
	private Date date;

	//@MapsId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "VENDOR_ID")
	private Vendor vendor;

	/////////////////////////////////////////////////////////////
	// -------------------GETTERS AND SETTERS------------------//
	/////////////////////////////////////////////////////////////
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
}	