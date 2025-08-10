package com.wipro.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeComparatorDemo {
	
	public static void main(String[] args) {
        List<Employees1> employees = new ArrayList<>();
        employees.add(new Employees1("E101", "Alice", 28, 75000));
        employees.add(new Employees1("E102", "Bob", 32, 90000));
        employees.add(new Employees1("E103", "Charlie", 25, 60000));
        employees.add(new Employees1("E104", "David", 30, 85000));

        
        System.out.println("Sorted by Salary (Descending):");
        Collections.sort(employees, new SalaryDescendingComparator());
        for (Employees1 e : employees) {
            System.out.println(e);
        }

        
        System.out.println("\nSorted by Age (Ascending):");
        Collections.sort(employees, new AgeAscendingComparator());
        for (Employees1 e : employees) {
            System.out.println(e);
        }

        
        System.out.println("\nSorted by Name (Alphabetical):");
        Collections.sort(employees, new NameAlphabeticalComparator());
        for (Employees1 e : employees) {
            System.out.println(e);
        }
    }

}
