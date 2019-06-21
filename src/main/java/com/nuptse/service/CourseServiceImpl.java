package com.nuptse.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;


//import com.nuptse.dao.CourseDAO;
import com.nuptse.model.Course;
import com.nuptse.model.Role;
import com.nuptse.model.User;
import com.nuptse.repository.CourseRepository;
import com.nuptse.repository.RoleRepository;
import com.nuptse.repository.UserRepository;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
	}

	@Override
	public Course findCourseByCourseName(String coursename) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseName(coursename);
	}
	
	@Override
	public java.util.List<Course> findAll() {
		// TODO Auto-generated method stub
     return courseRepository.findAll();
}
	@Override
	public Course findByCourseId(int id) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseId(id);
	}

	

	
}
