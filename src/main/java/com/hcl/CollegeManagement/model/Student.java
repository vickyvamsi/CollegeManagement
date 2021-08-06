package com.hcl.CollegeManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="std_tab")
public class Student {

	@Id
	@GeneratedValue
	private Long stdId;
	private String stdName;
	private String stdEmail;
	private String contact;
	private String address;
	
}
