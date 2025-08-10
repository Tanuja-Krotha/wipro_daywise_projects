package com.wipro.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortDemo 
{
	public static void main(String[] args) 
	{
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("E101", "A", 28, 75000));
        employees.add(new Employee("E102", "B", 32, 90000));
        employees.add(new Employee("E103", "C", 25, 60000));
        employees.add(new Employee("E104", "D", 30, 85000));

       
        Collections.sort(employees);

        
        for (Employee e : employees) 
        {
            System.out.println(e);
        }
	}	

}
