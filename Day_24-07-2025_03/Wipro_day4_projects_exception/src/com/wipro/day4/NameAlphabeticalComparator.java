package com.wipro.day4;

import java.util.Comparator;

public class NameAlphabeticalComparator implements Comparator<Employees1> {

	@Override
	public int compare(Employees1 e1, Employees1 e2) {
		 return e1.empName.compareToIgnoreCase(e2.empName);
	}

}
