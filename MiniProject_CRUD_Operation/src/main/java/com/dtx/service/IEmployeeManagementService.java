package com.dtx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dtx.model.Employee;

public interface IEmployeeManagementService {
	public Page<Employee> getAllEmployee(Pageable pageable);
	public Employee saveEmployee(Employee emp);
	public Employee editEmployee(int no);
	public void deleteEmploeeById(int no);
	
}
