package com.springboot.mongoDB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongoDB.model.Student;
import com.springboot.mongoDB.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@GetMapping(value = "/all")
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}
	
	@PostMapping(value = "/create")
	public String createStudent(@RequestBody Student student) {
		
		Student insertedStudent = studentRepository.insert(student);
		return "Student created "+ insertedStudent.getName();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		studentRepository.deleteById(id);
		return "Student got deleted ";
	}
	
	@GetMapping(value = "/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		
		return studentRepository.findById(id).orElse(null);
	}
	
	@PutMapping(value = "/update")
	public Student updateStudent(@RequestBody Student student) {
		Student oldStudent = null;
		Optional<Student> optionalStudent = studentRepository.findById(student.getId());
		if(optionalStudent.isPresent()) {
			oldStudent = optionalStudent.get();
			oldStudent.setName(student.getName());
			oldStudent.setAge(student.getAge());
			oldStudent.setMarks(student.getMarks());
			studentRepository.save(oldStudent);
		} else {
			return new Student();
		}
		return oldStudent;
	}

}
