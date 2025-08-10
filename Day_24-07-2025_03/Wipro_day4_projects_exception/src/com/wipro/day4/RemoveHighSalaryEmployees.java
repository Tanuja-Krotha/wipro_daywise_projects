package com.wipro.day4;

import java.util.concurrent.CopyOnWriteArrayList;

public class RemoveHighSalaryEmployees {

	public static void main(String[] args) 
	{
		
		CopyOnWriteArrayList<Employee> employees1 = new CopyOnWriteArrayList<>();

	     employees1.add(new Employee("E101", "Alice", 28, 75000));
	     employees1.add(new Employee("E102", "Bob", 32, 90000));
	     employees1.add(new Employee("E103", "Charlie", 25, 60000));
	     employees1.add(new Employee("E104", "David", 30, 85000));

	     System.out.println("Before removal:");
	        for (Employee e : employees1)
	        {
	            System.out.println(e);
	        }

	        
	        for (Employee e : employees1) 
	        {
	            if (e.empSalary > 80000) 
	            {
	                employees1.remove(e); 
	            }
	        }

	        System.out.println("\nAfter removal:");
	        for (Employee e : employees1) {
	            System.out.println(e);
	        }

	}

}
