package com.wipro.test;

import java.util.Scanner;

import com.wipro.oops.GPay;
import com.wipro.oops.*;
import com.wipro.oops.PaymentMethod;

public class PaymentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment method (gpay or phonepay):");
        String choice = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter amount to pay:");
        double amount = scanner.nextDouble();

        PaymentMethod payment;

        if (choice.equals("gpay")) {
            payment = new GPay();
            payment.pay(amount);
        } else if (choice.equals("phonepay")) {
            payment = new PhonePay();
            payment.pay(amount);
        } else {
            System.out.println("Invalid payment method selected.");
        }

        scanner.close();

	}

}
