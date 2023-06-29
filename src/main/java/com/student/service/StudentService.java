package com.student.service;

import java.util.List;

import com.student.entities.Student;

public interface StudentService {
	// getting the details of student
	List<Student> getAllStudents();
	
	//saving the details
	Student saveStudent(Student student);
	
	// updating the details
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	// deleting the student
	void deleteStudentById(Long id);
	
	
	

}
