package com.rithin.springbootcrud.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rithin.springbootcrud.model.Employee;
import com.rithin.springbootcrud.repository.EmployeeRepository;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeerepository.findAll();
	}
	
	//Add Employee
	@PostMapping("/employee")
	public Employee add(@RequestBody Employee employee) {
		return employeerepository.save(employee);
	}
	
	//Update Employee
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee) {
		return employeerepository.saveAndFlush(employee);
	}
	
	//Find particular Employee
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Optional<Employee> employee =  employeerepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new RuntimeException("Employee not found with the id "+id);
		}
	}

	//Delete Employee
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeerepository.deleteById(id);
		return "Employee with the id "+id+" has been deleted";
	}
	
	
}	
	/*@PostMapping("/employee")
	public Employee add(@RequestBody Employee employee) {
		employeeservice.add(employee);
		return employee;
	}
	
	@GetMapping("/employee/{id}")
	public Employee getId(@RequestBody Employee employee, @PathVariable int id) {
		Employee employeeobj =  employeeservice.get(id);
		if(employeeobj == null) {
			throw new RuntimeException("Employee with id "+id+" is not found");
		}
		else
			return employeeobj;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeservice.delete(id);
		return "Employee with id "+id+" has been deleted";
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee){
		employeeservice.add(employee);
		return employee;
		
	}*/
	


