package com.ids.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ids.dto.EmployeeDto;
import com.ids.model.Employee;
import com.ids.persistance.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public List<EmployeeDto> getEmployeesList() {

		return repository
				.findAll()
				.stream()
				.map(EmployeeDto::from)
				.collect(Collectors.toList());
	}

	public void saveEmployee(EmployeeDto empDto) {
		repository.save(new Employee(empDto.getEmpId(), empDto.getEmpName()));
	}
}
