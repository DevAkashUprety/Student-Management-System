package com.smsapp.sms.service;
import java.util.List;
import com.smsapp.sms.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	
	Void deleteStudentById(Long id);
}
