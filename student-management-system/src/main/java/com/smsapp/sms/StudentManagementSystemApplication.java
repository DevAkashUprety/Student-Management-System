package com.smsapp.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.smsapp.sms.entity.Student;
import com.smsapp.sms.repository.StrudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StrudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Student student1=new Student("Akash","Sharma","akashuprety1025@gmail.com");
		studentRepository.save(student1);
		
		Student student2=new Student("Mohit","Sharma","mohitvarma1025@gmail.com");
		studentRepository.save(student2);*/
	}

}
