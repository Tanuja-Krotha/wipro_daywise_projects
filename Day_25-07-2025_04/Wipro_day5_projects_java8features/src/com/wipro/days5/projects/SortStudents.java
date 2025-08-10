package com.wipro.days5.projects;

import java.util.ArrayList;
import java.util.List;

public class SortStudents {
	public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Jayanta", 85.5));
        students.add(new Student(102, "Amit", 92.0));
        students.add(new Student(103, "Vasu", 78.0));

       students.sort((s1, s2) -> s1.name.compareTo(s2.name));

        System.out.println("Sorted by Name:");
        for (Student s : students) {
            System.out.println(s);
        }
        
    }

}
