package com.hcl.CollegeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.CollegeManagement.model.Student;
import com.hcl.CollegeManagement.service.IStudentService;

@Controller
@RequestMapping("/Student")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student){
		
		try {
			System.out.println("Student Data From Front END :"+student);
			Long stdId=studentService.createStudent(student);
			return new ResponseEntity<>("Student created Sucess :"+stdId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error ",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/AllStudents")
	public ResponseEntity<?> getAllStudents(){
		List<Student> stds=studentService.getAllStudents();
		if(!stds.isEmpty() || stds!=null) 
			return new ResponseEntity<List<Student>>(stds,HttpStatus.OK);
		 else
			return new ResponseEntity<String>("No Data Found for Students",HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/oneStudent/{stdId}")
	public ResponseEntity<?> getOneStudent(@PathVariable Long stdId){
		Optional<Student> student=studentService.getOneStudent(stdId);
		if(!student.isPresent()) {
			return new ResponseEntity<String>("Student Not Found :"+stdId, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{stdId}")
	public ResponseEntity<?> deleteStudentById(@PathVariable Long stdId){
		Optional<Student> student=studentService.getOneStudent(stdId);
		if(student.isPresent()) {
			studentService.removeStudent(stdId);
			return new ResponseEntity<String>(" Student Id :"+stdId+" Sucessful Deleted",HttpStatus.OK);
		}
		return  new ResponseEntity<String>("Unable to Delete the Student , Not Found Id :" +stdId,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateStudent/{stdId}")
	public ResponseEntity<String> updateStudent(@PathVariable Long stdId,@RequestBody Student student){
		
		return new ResponseEntity<String>(studentService.updateStudent(stdId, student),HttpStatus.OK);
	}
}
