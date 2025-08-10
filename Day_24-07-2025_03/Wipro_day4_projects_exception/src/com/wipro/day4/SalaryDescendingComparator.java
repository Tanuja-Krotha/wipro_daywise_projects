package com.wipro.day4;

import java.util.Comparator;

public class SalaryDescendingComparator implements Comparator<Employees1> 
{

	@Override
	public int compare(Employees1 e1, Employees1 e2) {
		return Double.compare(e2.empSalary, e1.empSalary); 
	}
	
}
