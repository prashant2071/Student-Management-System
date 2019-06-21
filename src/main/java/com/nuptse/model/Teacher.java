package com.nuptse.model;

import java.sql.Date;
import org.springframework.data.annotation.Transient;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "teacher")
public class Teacher {
@Id
@GeneratedValue (strategy=GenerationType.AUTO)
@Column(name="teacher_id")
private int id;

@Column(name="teacher_name")
private String name;

@Column(name="address")
private String address;

@Column(name="phone_no")
private int phoneno;

@Column(name="joinedDate")
private Date joinedDate;

public Date getJoinedDate() {
	return joinedDate;
}
public void setJoinedDate(Date joinedDate) {
	this.joinedDate = joinedDate;
}
public int getPhoneno() {
	return phoneno;
}
public void setPhoneno(int phoneno) {
	this.phoneno = phoneno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}







}
