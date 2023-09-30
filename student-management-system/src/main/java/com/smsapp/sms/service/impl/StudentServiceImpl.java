package com.smsapp.sms.service.impl;

import com.smsapp.sms.service.StudentService;
import java.util.List;

import org.springframework.stereotype.Service;
import com.smsapp.sms.repository.StrudentRepository;
import com.smsapp.sms.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StrudentRepository studentRepository;
	
	public StudentServiceImpl(StrudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	
	@Override
	public List<Student> getAllStudents(){
		
		return studentRepository.findAll() ;
	}
	
	@Override
	public Student saveStudent(Student student){
		
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public Void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return null;
	}

	
	
	
}
