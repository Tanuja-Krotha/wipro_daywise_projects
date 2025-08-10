package com.wipro.day4;

import java.util.Comparator;

public class AgeAscendingComparator implements Comparator<Employees1>  {

	@Override
	public int compare(Employees1 e1, Employees1 e2) {
		// TODO Auto-generated method stub
		return Integer.compare(e1.empAge, e2.empAge);
	}

}
