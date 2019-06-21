package com.nuptse.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private int id;

	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide your name")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;

	@Column(name = "address")
	@NotEmpty(message = "*Please provide an address")
	private String address;

	@Column(name = "phone_number")
	@NotEmpty(message = "*Please provide a phone number")
	private String phoneNumber;

	@Column(name = "Father_name")
	@NotEmpty(message = "*Please provide your Father's name")
	private String fatherName;

	@Column(name = "joined_year")
	@NotEmpty(message = "*Please provide college joined year")
	private String joinedYear;

	@Column(name = "birth_date")
	@NotEmpty(message = "*Please provide your birth date")
	private String birthDate;

	@Column(name = "email_id")
	@NotEmpty(message = "*Please provide your email id")
	private String emailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getJoinedYear() {
		return joinedYear;
	}

	public void setJoinedYear(String joinedYear) {
		this.joinedYear = joinedYear;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

	
}
