package com.wipo.day.projects;

public class SecondLargestNumberinArray {

	public static void main(String[] args) {

		int[] arr1 = {10, 5, 20, 8, 15};
		int len = arr1.length;
		for(int i=0; i<len; i++)
		{
			for(int j=i;j<len;j++)
			{
				if(arr1[i]>arr1[j])
				{
					int temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}
		}
		
		System.out.print(arr1[len-2]);

	}

}
