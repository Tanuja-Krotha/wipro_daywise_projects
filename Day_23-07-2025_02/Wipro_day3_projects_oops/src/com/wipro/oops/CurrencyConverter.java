package com.wipro.oops;

public class CurrencyConverter {

   
    public static int changeCurrency(int number) throws NumberFormatException {
        if (number == 0) {
            throw new NumberFormatException("Invalid Number");
        }
        return number * 80; 
    }

    public static void main(String[] args) {
        try {
            int input = 0; 
            int result = changeCurrency(input);
            System.out.println("Converted currency: ₹" + result);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
