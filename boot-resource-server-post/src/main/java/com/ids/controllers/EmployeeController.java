package com.ids.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ids.dto.EmployeeDto;
import com.ids.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/user/getEmployeesList", produces = "application/json")
	public List<EmployeeDto> getEmployeesList() {
		return employeeService.getEmployeesList();
	}

	@PostMapping("/user/saveEmployee") 
	 public void postEmployee(@RequestBody EmployeeDto empDto)
	 {
		employeeService.saveEmployee(empDto);
	 }
}
