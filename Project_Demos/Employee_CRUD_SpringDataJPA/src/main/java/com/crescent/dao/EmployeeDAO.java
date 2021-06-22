package com.crescent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crescent.beans.Employee;


public interface EmployeeDAO extends JpaRepository<Employee, String> {

}
