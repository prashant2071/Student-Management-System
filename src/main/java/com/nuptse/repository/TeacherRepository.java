package com.nuptse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuptse.model.Teacher;

@Repository("teacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByName(String name);
    Teacher findById(Integer id);
    
    
}