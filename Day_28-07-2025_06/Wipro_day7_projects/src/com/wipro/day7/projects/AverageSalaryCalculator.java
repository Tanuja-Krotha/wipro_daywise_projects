package com.wipro.day7.projects;

import java.util.*;

public class AverageSalaryCalculator 
{
    public static void main(String[] args) 
    {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 25, 40000),
            new Employee("Alice", 35, 60000),
            new Employee("Bob", 40, 70000),
            new Employee("Charlie", 20, 30000),
            new Employee("David", 38, 55000)
        );

        OptionalDouble averageSalary = employees
        	.stream()
            .filter(emp -> emp.getAge() > 30 && emp.getSalary() > 50000)
            .mapToDouble(Employee::getSalary)
            .average();

        
        if (averageSalary.isPresent()) 
        {
            System.out.println("Average salary: " + averageSalary.getAsDouble());
        } 
        else
        {
            System.out.println("No employees match the criteria.");
        }
    }
}

