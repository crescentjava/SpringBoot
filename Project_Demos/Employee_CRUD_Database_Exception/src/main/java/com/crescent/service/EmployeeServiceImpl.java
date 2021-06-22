package com.crescent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crescent.beans.Employee;
import com.crescent.dao.EmployeeDAO;
import com.crescent.exceptions.EmployeeExistsException;
import com.crescent.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDao;
	
	
	  /* (non-Javadoc)
	 * @see com.crescent.service.EmployeeService#getAllEmployee()
	 */
	@Override
	public List<Employee> getAllEmployee()
	  {
		  return employeeDao.findAll();
	  }
	  
	  /* (non-Javadoc)
	 * @see com.crescent.service.EmployeeService#getEmployeeById(java.lang.String)
	 */
	@Override
	public Optional<Employee> getEmployeeById(String empId)throws EmployeeNotFoundException
	  {
		 // return employeeDao.getOne(empId);
		  Optional<Employee> employee = employeeDao.findById(empId);
		  if(!employee.isPresent())
		  {
			  throw new EmployeeNotFoundException("Employee not found");
		  }
		  
		  return employee;
	  }
	  
	  /* (non-Javadoc)
	 * @see com.crescent.service.EmployeeService#addEmployee(com.crescent.beans.Employee)
	 */
	@Override
	public Employee addEmployee(Employee employee)throws EmployeeExistsException
	  {
		  Optional<Employee> existingEmployee=employeeDao.findById(employee.getEmpId());
		  System.out.println("Existing employee "+existingEmployee);
		  if(existingEmployee.isPresent())
		  {
			  System.out.println("Inside if");
			  throw new EmployeeExistsException("Employee already exists");
		  }
		 return employeeDao.save(employee);
	  }
	  
	  /* (non-Javadoc)
	 * @see com.crescent.service.EmployeeService#updateEmployee(java.lang.String, com.crescent.beans.Employee)
	 */
	@Override
	public Employee updateEmployee(String empId,Employee emp)throws EmployeeNotFoundException
	  {
		  Optional<Employee> employee = employeeDao.findById(empId);
		  if(!employee.isPresent())
		  {
			  throw new EmployeeNotFoundException("this employee record is not available, pls provide correct one");
		  }
		return  employeeDao.save(emp);
	  }
	  
	  /* (non-Javadoc)
	 * @see com.crescent.service.EmployeeService#deleteEmployee(java.lang.String)
	 */
	@Override
	public void deleteEmployee(String empId)
	  {
		  Optional<Employee> employee = employeeDao.findById(empId);
		  if(!employee.isPresent())
		  {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"this employee record is not available, pls provide correct one");
		  }
		  employeeDao.deleteById(empId);
	  }

}
