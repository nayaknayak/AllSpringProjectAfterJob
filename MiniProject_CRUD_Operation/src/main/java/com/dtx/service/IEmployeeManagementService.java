package com.dtx.service;

import java.util.List;

import com.dtx.model.Employee;

public interface IEmployeeManagementService {
	public List<Employee> getAllEmployee();
	public Employee saveEmployee(Employee emp);
	public Employee editEmployee(int no);
	public void deleteEmploeeById(int no);
}
