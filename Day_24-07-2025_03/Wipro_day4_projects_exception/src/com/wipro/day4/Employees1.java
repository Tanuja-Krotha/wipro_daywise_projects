package com.wipro.day4;

public class Employees1 
{
	  String empId;
	 String empName;
	  int empAge;
	  double empSalary;
	
	 public Employees1(String empId, String empName, int empAge, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
	 }

	 public String getEmpId() {
		 return empId;
	 }

	 public void setEmpId(String empId) {
		 this.empId = empId;
	 }

	 public String getEmpName() {
		 return empName;
	 }

	 public void setEmpName(String empName) {
		 this.empName = empName;
	 }

	 public int getEmpAge() {
		 return empAge;
	 }

	 public void setEmpAge(int empAge) {
		 this.empAge = empAge;
	 }

	 public double getEmpSalary() {
		 return empSalary;
	 }

	 public void setEmpSalary(double empSalary) {
		 this.empSalary = empSalary;
	 }

	 @Override
	 public String toString() {
		return "Employees1 [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ "]";
	 }
	 
	 
	 
	 
	
}
