package com.smsapp.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smsapp.sms.service.StudentService;
import com.smsapp.sms.entity.Student;
@Controller
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list student and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
		
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form dta
		Student student=new Student();
		model.addAttribute("student", student);
		return "createStudent";
		
		}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student")Student student) {
		
		studentService.saveStudent(student);
		System.out.println(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "editStudent";
	}
	
	@PostMapping("/students/{id}")
	public String UpdateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		
		//get student from database by id
		Student exisitingStudent = studentService.getStudentById(id);
		exisitingStudent.setId(id);
		exisitingStudent.setFirstName(student.getFirstName());
		exisitingStudent.setLastName(student.getLastName());
		exisitingStudent.setEmail(student.getEmail());
		
		//Save updated Student objects
		studentService.updateStudent(exisitingStudent);
		return "redirect:/students";
	}
	
	//handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
