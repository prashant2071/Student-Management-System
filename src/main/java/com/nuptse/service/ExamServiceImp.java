package com.nuptse.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nuptse.model.Exam;
import com.nuptse.model.Role;
import com.nuptse.model.User;
import com.nuptse.repository.ExamRepository;
import com.nuptse.repository.RoleRepository;
import com.nuptse.repository.UserRepository;

@Service("examService")
public class ExamServiceImp implements ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Override
	public Exam findExamByFirstname(String Firstname) {
		return examRepository.findByFirstname(Firstname);
	}

	@Override
	public void saveExam(Exam exam) {

		examRepository.save(exam);

	}

	@Override
	public java.util.List<Exam> findAll() {
		// TODO Auto-generated method stub
		return examRepository.findAll();
	}

	@Override
	public Exam findExamById(Integer id) {
		// TODO Auto-generated method stub
		return examRepository.findById(id);
	}
}
