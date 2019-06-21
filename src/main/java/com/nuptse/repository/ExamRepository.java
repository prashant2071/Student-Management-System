package com.nuptse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuptse.model.Exam;
import java.util.List;

@Repository("examRepository")
public interface ExamRepository extends JpaRepository<Exam, Long> {
	Exam findByFirstname(String Firstname);
	public List<Exam> findAll(); 
	Exam findById( int id );

	
	  
}
