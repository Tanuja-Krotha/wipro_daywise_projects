package com.wipro.employee_management.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.employee_management.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

	List<Employee> getEmployeeByName(String name);

}
