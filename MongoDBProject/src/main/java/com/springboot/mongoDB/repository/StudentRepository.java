package com.springboot.mongoDB.repository ;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongoDB.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>{

}
