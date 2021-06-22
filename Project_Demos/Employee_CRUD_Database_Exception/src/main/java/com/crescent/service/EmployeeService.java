package com.crescent.service;

import java.util.List;
import java.util.Optional;

import com.crescent.beans.Employee;
import com.crescent.exceptions.EmployeeExistsException;
import com.crescent.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Optional<Employee> getEmployeeById(String empId) throws EmployeeNotFoundException;

	Employee addEmployee(Employee employee) throws EmployeeExistsException;

	Employee updateEmployee(String empId, Employee emp) throws EmployeeNotFoundException;

	void deleteEmployee(String empId);

}