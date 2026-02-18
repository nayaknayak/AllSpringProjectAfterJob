package com.dtx.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dtx.model.Employee;
import com.dtx.service.EmployeeManagementService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeOperationController {
	@Autowired
	private EmployeeManagementService service;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
		
	@GetMapping("/report")
	public String showEmployeeReport(@PageableDefault(page=0,size=5) Pageable pageable,Map<String,Object> map) {
		Page<Employee> page = service.getAllEmployee(pageable);
		map.put("listOfEmployee", page);
		return "employee_report";
	}
	
	@GetMapping("/add")
	public String registerEmployee(Map<String,Object> map,@ModelAttribute("emp") Employee emp) {
		emp.setJob("Clerk"); // intial default name;
		return "employee_regstation";
		
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map,HttpSession httpSess) {
		Employee savedEmployee=service.saveEmployee(emp);
	//	map.put("id", savedEmployee.getEmpNo());
		httpSess.setAttribute("id", savedEmployee.getEmpNo());
		//return "redirect:message";
		return "redirect:message";
	}
	
	@GetMapping("edit")
	public String editEmployeeData(@RequestParam int no,@ModelAttribute("emp") Employee emp) {
		Employee editEmployee= service.editEmployee(no);
		BeanUtils.copyProperties(editEmployee, emp);
		return "employee_edit";
	}
	@PostMapping("/edit")
	public String saveEditedEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map,HttpSession https) {
		System.out.println("Employee id :" + emp.getEmpNo());
		Employee savedEmployee=service.saveEmployee(emp);
		https.setAttribute("id", savedEmployee.getEmpNo());
		//map.put("id", savedEmployee.getEmpNo());
		return "redirect:message";
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam int no,Map<String,Object> map) {
		service.deleteEmploeeById(no);
		map.put("deleteId", no);
		return "employee_delete";
	}
	@GetMapping("/message")
	public String showMessage(Map<String,Object> map,HttpSession http) {
		map.put("id", http.getAttribute("id"));
		http.removeAttribute("id");
		return "employee_message";
	}
	
	
	

}
