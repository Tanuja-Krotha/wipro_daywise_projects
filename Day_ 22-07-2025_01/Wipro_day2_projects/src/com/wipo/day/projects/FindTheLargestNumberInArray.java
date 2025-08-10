package com.wipo.day.projects;

public class FindTheLargestNumberInArray {

	public static void main(String[] args) {

		int[] arr1 = {100,67,98,678,45,123};
		int big = 0;
		int len = arr1.length;
		for(int i=0; i<len;i++)
		{
			if(arr1[i]>big)
			{
				big = arr1[i];
			}
		}
		System.out.println(big);
	}
}
