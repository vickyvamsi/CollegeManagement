package com.hcl.CollegeManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.CollegeManagement.exception.StudentNotFoundException;
import com.hcl.CollegeManagement.model.Student;
import com.hcl.CollegeManagement.repository.StudentRepository;
import com.hcl.CollegeManagement.service.IStudentService;

@Service
 public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Long createStudent(Student student) {
		Student std=studentRepository.save(student);
		return std.getStdId();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void removeStudent(Long stdId) {
		studentRepository.deleteById(stdId);
		
	}

	@Override
	public Optional<Student> getOneStudent(Long stdId) {
		Optional<Student> std=studentRepository.findById(stdId);
		return std;
	}

	@Override
	public String updateStudent(Long stdId,Student student)throws StudentNotFoundException {
		Optional<Student> studentInfo=studentRepository.findById(stdId);
		if(studentInfo.isPresent()) {
			studentRepository.save(student);
			return "Student Data Updated Sucess";
		}else {
			return "Student Data Not Found : "+stdId;
			//throw new StudentNotFoundException("Student Data Not Found : "+stdId);
		}
		
	}
	
	
	
	
		
	
	
}
