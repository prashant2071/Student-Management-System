package com.nuptse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuptse.model.Course;
@Repository("couseRepository")
public interface CourseRepository extends JpaRepository<Course, Integer>{
	  Course findByCourseName(String coursename);
	  Course findByCourseId(int id);
}
