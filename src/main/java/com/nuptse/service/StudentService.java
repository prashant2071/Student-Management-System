package com.nuptse.service;

import java.util.List;

import com.nuptse.model.Student;

public interface StudentService {
	public Student findStudentById(int id);
    public void saveStudent(Student student);
	public List<Student> findAll();
}

