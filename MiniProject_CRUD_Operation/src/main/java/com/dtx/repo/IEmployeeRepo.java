package com.dtx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dtx.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
