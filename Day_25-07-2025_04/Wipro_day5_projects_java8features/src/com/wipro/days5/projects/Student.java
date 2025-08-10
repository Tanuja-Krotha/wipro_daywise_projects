package com.wipro.days5.projects;

public class Student {
	 int rollNo;
	 String name;
	 double marks;
	 
	 public Student(int rollNo, String name, double marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	 }
	 
	 public int getRollNo() {
		 return rollNo;
	 }
	 public void setRollNo(int rollNo) {
		 this.rollNo = rollNo;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public double getMarks() {
		 return marks;
	 }
	 public void setMarks(double marks) {
		 this.marks = marks;
	 }
	 @Override
	 public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	 }
	 
	 
}
