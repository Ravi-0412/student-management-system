package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entities.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to handle list students request and return mode and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		// it's key-value pair. key=> any message(ur wish) & value: from where we will
		// get that.
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold the student data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students"; // after saving it will redirect to page "students'(GetMapping one)
	}

	// for updating
	// first we have to get the student id

	@GetMapping("/students/edit/{id}") // url that we gave to go on after clicking the update button
	public String editStudentForm(@PathVariable Long id, Model model) {
		// pathVariable to map the id
		// we have to get id from database so we will use the function of studentService
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	// then we have to handle the request

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") 
	Student student, Model model) {
		
		// pathVariable is for mapping the 'id' with object 'student'.
		// we have to update the details of student with 'id' with details of 'student'
		// 'student' we are getting from page
		
		// get the student from db by id
		Student s = studentService.getStudentById(id);
		
		// update the 'student' detail in 's'
		s.setId(student.getId());
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		
		// save the updated student object in DB
		studentService.updateStudent(s);
		return "redirect:/students";		
	}
	
	// handler method to handle the delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		 
		
	}
	
	
	
	
}
