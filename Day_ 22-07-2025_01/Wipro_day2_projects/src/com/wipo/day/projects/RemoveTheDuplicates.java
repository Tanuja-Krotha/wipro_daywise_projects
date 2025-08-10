package com.wipo.day.projects;

public class RemoveTheDuplicates {

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
		int n = arr.length, j=0;
		int[] res = new int[n];
		
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]!=arr[i+1])
			{
				res[j++]= arr[i];
			}
		}
		res[j++] = arr[n-1];
		for(int i=0; i<j;i++)
		{
			System.out.print(res[i]+" ");
		}
		System.out.println();
		System.out.println(res.length+" ");
	}

}
