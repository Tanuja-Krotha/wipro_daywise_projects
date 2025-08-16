package com.wipro.employee_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.employee_management.entity.Employee;
import com.wipro.employee_management.exception.ResourceNotFoundException;
import com.wipro.employee_management.repo.EmployeeRepository;
import com.wipro.employee_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	 	@Autowired
	    private EmployeeRepository repo;

	    @Override
	    public Employee saveEmployee(Employee employee) {
	        return repo.save(employee);
	    }

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return repo.findById(id)
	                   .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
	    }
	    
	    

	    @Override
	    public Employee updateEmployee(Long id, Employee employee) {
	        Employee existing = getEmployeeById(id);
	        existing.setName(employee.getName());
	        existing.setEmail(employee.getEmail());
	        existing.setType(employee.getType());
	        existing.setAddress(employee.getAddress());
	        existing.setDepartment(employee.getDepartment());
	        return repo.save(existing);
	    }
	    
	    @Override
	    public void deleteEmployee(Long id) {
	        Employee emp = getEmployeeById(id);
	        repo.delete(emp);
	    }
	    
	    @Override
	    public List<Employee> getAllEmployees() {
	        return repo.findAll();
	    }

		

		

		

		
	    
	    

}
