package com.nuptse.service;

import java.util.List;

import com.nuptse.model.Teacher;

public interface TeacherService {
    public Teacher findTeacherByName(String name);
    public Teacher findTeacherById(Integer id);
    public void saveTeacher(Teacher teacher);
	List<Teacher> findAll();
}