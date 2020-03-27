package com.ids.dto;

import com.ids.model.Employee;

public class EmployeeDto {
	
	private String empId;
    private String empName;
	
    public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public EmployeeDto() {
	}

	public EmployeeDto(String empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public static EmployeeDto from(Employee emp) {
    	return new EmployeeDto(emp.getEmpId(), emp.getEmpName());    	
    }
	
}
