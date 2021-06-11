package com.ms.h2.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.h2.model.Student;
import com.ms.h2.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		Student oldStudent = null;
		Optional<Student> optionalStudent = studentRepository.findById(student.getId());
		if(optionalStudent.isPresent()) {
			oldStudent = optionalStudent.get();
			oldStudent.setName(student.getName());
			oldStudent.setAge(student.getAge());
			oldStudent.setEmail(student.getEmail());
			studentRepository.save(oldStudent);
		} else {
			return new Student();
		}
		return oldStudent;
	}
	
	public String deleteStudentById(int id) {
		studentRepository.deleteById(id);
		return "Student got deleted";
	}

}
