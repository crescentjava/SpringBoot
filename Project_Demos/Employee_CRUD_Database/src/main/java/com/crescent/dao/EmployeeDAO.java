package com.crescent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.boot.json.JsonParser;
//import org.springframework.data.jpa.repository;
import org.springframework.data.repository.CrudRepository;

import com.crescent.beans.Employee;
public interface EmployeeDAO extends JpaRepository<Employee, String> {

}
