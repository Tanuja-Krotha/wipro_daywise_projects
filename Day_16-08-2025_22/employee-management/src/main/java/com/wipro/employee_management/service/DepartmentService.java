package com.wipro.employee_management.service;

import java.util.List;

import com.wipro.employee_management.entity.Department;

public interface DepartmentService {
	List<Department> getAllDepartments();
    
	Department getDepartmentById(Long id);
    
	Department saveDepartment(Department department);
    
	void deleteDepartmentById(Long id);
}
