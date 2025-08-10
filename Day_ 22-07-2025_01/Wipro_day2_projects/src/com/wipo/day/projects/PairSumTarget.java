package com.wipo.day.projects;

public class PairSumTarget {

	public static void main(String[] args) {
		int[] arr = {2, 1, 7, 3}; 
        int target = 9;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Indices: [" + i + ", " + j + "]");
                    return;
                }
            }
        }
        System.out.println("No pair found");

	}

}
