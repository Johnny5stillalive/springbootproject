package com.screcruiting.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="RESUME")
public class Resume 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="RESUME_ID")
	private int id;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="CONTENT")
	private String content;
	
	//@MapsId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CONSULTANT_ID")
	private Consultant consultant;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="resume", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ResumeSubmission> submissions;

	/*
	//First name, last name? Let's keep it simple for now as whatever they want..
	@Column(name ="NAME")
	private String name;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="ZIPCODE")
	private String zipCode;
	*/
}
