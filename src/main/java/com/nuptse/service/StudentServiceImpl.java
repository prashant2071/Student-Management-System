package com.nuptse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nuptse.model.Student;
import com.nuptse.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findStudentById(int id) {

		return studentRepository.findById(id);
	}
	
	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public java.util.List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	

}
