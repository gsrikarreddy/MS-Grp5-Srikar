package com.ms.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.h2.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
