package com.crescent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crescent.beans.Employee;
import com.crescent.dao.EmployeeDAO;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDao;
	
	
	  public List<Employee> getAllEmployee()
	  {
		  return employeeDao.findAll();
	  }
	  
	  public Employee getEmployeeById(String empId)
	  {
		  return employeeDao.getOne(empId);
	  }
	  
	  public void addEmployee(Employee employee)
	  {
		  employeeDao.save(employee);
	  }
	  
	  public void updateEmployee(String empId,Employee employee)
	  {
		 employeeDao.save(employee);
	  }
	  
	  public void deleteEmployee(String empId)
	  {
		  employeeDao.deleteById(empId);
	  }

}
