package com.nuptse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuptse.model.Teacher;
import com.nuptse.repository.TeacherRepository;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher findTeacherByName(String name) {
		return teacherRepository.findByName(name);
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherRepository.save(teacher);
	}
	@Override
	public List<Teacher> findAll(){
		return  teacherRepository.findAll();
		
	}
	@Override
	public Teacher findTeacherById(Integer id){
		return teacherRepository.findById(id);
	}
	
}
