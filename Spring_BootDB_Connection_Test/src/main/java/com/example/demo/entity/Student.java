package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private int rollNo;
	@Column(name = "Student_Name")
	private String nameOfStudent;
	private String fName;
	

}
