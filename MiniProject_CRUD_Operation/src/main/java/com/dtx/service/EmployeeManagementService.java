package com.dtx.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dtx.model.Employee;
import com.dtx.repo.IEmployeeRepo;
@Service
public class EmployeeManagementService implements IEmployeeManagementService {
	@Autowired
	public IEmployeeRepo repo;

	@Override
	public Page<Employee> getAllEmployee(Pageable pageable) {
		//Employee empSaved = repo.save(emp);
		Page<Employee> page =repo.findAll( pageable);
		
		
		return page;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		
		
		return repo.save(emp);
	}

	@Override
	public Employee editEmployee(int no) {
		Employee emp = repo.findById(no).get();
		return emp ;
	}

	@Override
	public void deleteEmploeeById(int no) {
		repo.deleteById(no);
		
	}
	
	
	
	


}
