package com.crescent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.crescent.beans.Employee;
import com.crescent.exceptions.EmployeeExistsException;
import com.crescent.exceptions.EmployeeNotFoundException;
import com.crescent.service.EmployeeService;

@RestController
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable String empId)
	{
		try {
		return employeeService.getEmployeeById(empId);
		}catch(EmployeeNotFoundException ex)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	@PostMapping("/employee")  
	public Employee addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder)
	{
		try
		{
			Employee emp=employeeService.addEmployee(employee);
			System.out.println("Employee object "+emp);
		return emp;
		}catch(EmployeeExistsException ex)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable String empId)
	{
		try {
		return employeeService.updateEmployee(empId, employee);
		}catch(EmployeeNotFoundException ex)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
		}
	}
	
	@DeleteMapping("/employee/{empId}")
	public void deleteEmployee(@PathVariable String empId)
	{
		employeeService.deleteEmployee(empId);
	}
}
