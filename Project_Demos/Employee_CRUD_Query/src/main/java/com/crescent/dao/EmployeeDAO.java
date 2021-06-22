package com.crescent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.boot.json.JsonParser;
//import org.springframework.data.jpa.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crescent.beans.Employee;
public interface EmployeeDAO extends JpaRepository<Employee, String> {
		
	List<Employee> findByName(String name);
	
	List<Employee> findBySalaryBetween(double lower,double higher);
	
	@Query("from Employee where name=:empName")
    List<Employee> getEmployeeDetailsByName(@Param("empName") String name);
	
	@Query("from Employee where salary>=:lower and salary<=:higher")
	 List<Employee> getEmployeeDetailsBySalRange(@Param("lower") double lowsal,@Param("higher") double highsal );

}
