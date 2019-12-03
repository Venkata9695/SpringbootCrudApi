package com.rithin.springbootcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rithin.springbootcrud.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
