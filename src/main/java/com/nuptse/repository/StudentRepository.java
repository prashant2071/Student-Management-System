package com.nuptse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuptse.model.Student;


@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findById(int id);

}
