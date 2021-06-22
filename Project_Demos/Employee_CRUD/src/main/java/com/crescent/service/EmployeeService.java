package com.crescent.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crescent.beans.Employee;

@Service
public class EmployeeService {
	
	
	List<Employee> emps=new ArrayList<>(Arrays.asList(
			
			
			new Employee("101","Sachin","Consultant",50000),
			new Employee("102","Sanjay","Senior Consultant",70000),
			new Employee("103","Vishal","Manager",90000)
			
			));
	
	
	  public List<Employee> getAllEmployee()
	  {
		  return emps;
	  }
	  
	  public Employee getEmployeeById(String empId)
	  {
		  return emps.stream().filter(e->e.getEmpId().equals(empId)).findFirst().get();
	  }
	  
	  public void addEmployee(Employee employee)
	  {
		  emps.add(employee);
	  }
	  
	  public void updateEmployee(String empId,Employee employee)
	  {
		  for(int i=0;i<emps.size();i++)
		  {
			  Employee e = emps.get(i);
			  if(e.getEmpId().equals(empId))
			  {
				  emps.set(i, employee);
				  return;
				  
			  }
		  }
	  }
	  
	  public void deleteEmployee(String empId)
	  {
		  emps.removeIf(e->e.getEmpId().equals(empId));
	  }

}
