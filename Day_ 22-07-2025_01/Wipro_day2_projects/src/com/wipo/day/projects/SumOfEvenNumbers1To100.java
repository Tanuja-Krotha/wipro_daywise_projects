package com.wipo.day.projects;

public class SumOfEvenNumbers1To100 {

	public static void main(String[] args) {

		int num = 100,i=1,sum=0;
		for(i=1;i<=num;i++)
		{
			if(i%2==0)
			{
				sum+=i;
			}
		}
		System.out.print(sum);
	}

}
