package com.nuptse.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Exam haru increase hudai jada id haru primary auto increment hudai jane
	@Column(name = "exam_id")
	private int id;
	@Column(name = "First_name")
	private String firstname;
	@Column(name = "Last_name")
	private String lastname;

	@Column(name = "Subject")
	private String subject;
	@Column(name = "exam_date")
	@Transient
	private String examDate;
	@Column(name = "invigilator_name")
	private String invigilatorName;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String Firstname) {
		this.firstname = Firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getInvigilatorName() {
		return invigilatorName;
	}

	public void setInvigilatorName(String invigilatorName) {
		this.invigilatorName = invigilatorName;
	}

}