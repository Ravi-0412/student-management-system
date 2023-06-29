package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.entities.Student;
import com.student.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		System.out.println("project started....");
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1 = new Student("Ramesh","Saxsena","ramesh@gmail.com");
//		studentRepository.save(student1);
//		Student student2 = new Student("Rahul","Singh","rahul@gmail.com");
//		studentRepository.save(student2);
//		Student student3 = new Student("Yash","kumar","yash@gmail.com");
//		studentRepository.save(student3);
//		Student student4 = new Student("Ravi","Rashan","ravi@gmail.com");
//		studentRepository.save(student4);
		
	}

}
