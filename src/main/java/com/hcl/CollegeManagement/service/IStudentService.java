package com.hcl.CollegeManagement.service;

import java.util.List;
import java.util.Optional;

import com.hcl.CollegeManagement.model.Student;

public interface IStudentService {

	public Long createStudent(Student student);
	public List<Student> getAllStudents();
	public void removeStudent(Long stdId);
	public Optional<Student> getOneStudent(Long stdId);
	public String updateStudent(Long stdId,Student student);
}
