package com.dtx.model;

import java.io.Serializable;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DialectOverride.ColumnDefaults;
import org.hibernate.annotations.SQLDelete;
//import org.hibernate.annotations.Where;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder.Default;
import lombok.Data;
//import jakarta.persistence.Where;   // THIS DOES NOT EXIST

@Entity
@Data
@SQLDelete(sql="update employee_test set status = 'inactive' where emp_No = ?")
//@Where(clause="status<>'inactive'")
@SQLRestriction("status<>'inactive'")

@Table(name= "Employee_Test")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empNo;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job;
	private Float sal;
	//@Column(default ="active")
	//@Default("active")
	//@ColumnDefaults("active")
	private String status="active";
	

}
