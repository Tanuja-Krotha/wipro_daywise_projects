package com.wipro.oops;

public class NullPointerExample {
    public static void main(String[] args) {
        String fName = null;

        try
        {
            String upper = fName.toUpperCase();
            System.out.println("Uppercase name: " + upper);
        } 
        catch (NullPointerException e) 
        {
            e.printStackTrace();

        }
    }
}

