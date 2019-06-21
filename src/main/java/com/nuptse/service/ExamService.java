package com.nuptse.service;

import java.util.List;

import com.nuptse.model.Exam;

public interface ExamService {

	public Exam findExamByFirstname(String Firstname);

	// public Exam findExamByExamId(int id);

	public void saveExam(Exam exam);

	public List<Exam> findAll();

	//Exam findExamById(Integer id);

	 Exam findExamById(Integer id);

}
