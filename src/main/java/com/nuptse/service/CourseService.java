package com.nuptse.service;

//import antlr.collections.List;
import java.util.List;

import com.nuptse.model.Course;


public interface CourseService {
	 public Course findCourseByCourseName(String coursename);
	 
     public void saveCourse(Course course );
    
     Course findByCourseId(int id);
     public List<Course> findAll();
  
    

}
