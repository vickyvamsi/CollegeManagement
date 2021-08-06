package com.hcl.CollegeManagement.exception;

public class StudentNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = -5099727750658252477L;
	
	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
