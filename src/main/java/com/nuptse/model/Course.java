package com.nuptse.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int courseId;
	@Column(name = "name")
	@NotEmpty(message = "*Please provide your course name")
	private String courseName;
	@Column(name = "description")
	@NotEmpty(message = "*Please provide course description")
	private String description;
	@Column(name = "study_hours")
	@NotEmpty(message = "*Please provide study hours")
	@Size(min = 1, max = 30)
	private String studyHours;
	@Column(name = "start_date")
	@NotEmpty(message = "*Please provide course reference book name")
	// @DateTimeFormat(pattern = "yyyy-mm-dd");
	private String startDate;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudyHours() {
		return studyHours;
	}

	public void setStudyHours(String studyHours) {
		this.studyHours = studyHours;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	// public String toString(){
	// return this.courseName;
	// }

}
