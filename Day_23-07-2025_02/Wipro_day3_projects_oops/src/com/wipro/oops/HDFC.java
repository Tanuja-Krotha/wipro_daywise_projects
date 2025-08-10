package com.wipro.oops;

public class HDFC implements BanksOps{

	 private String accNumber;
	 private double balance;
	
	 public HDFC(String accNumber) 
	 {
	        this.accNumber = accNumber;
	        this.balance = 0.0;
	  }

	 
	@Override
	public void deposit(double amount, String accNumber) 
	{
		
		if (this.accNumber.equals(accNumber)) 
		{
            balance += amount;
            System.out.println("HDFC: Deposited ₹" + amount + " into account " + accNumber);
        } 
		else 
		{
            System.out.println("HDFC: Invalid account number!");
        }
		
		
	}

	@Override
	public double withdraw(double amount, String accNumber)
	{
		
		if (this.accNumber.equals(accNumber)) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("HDFC: Withdrawn ₹" + amount + " from account " + accNumber);
                return amount;
            } else {
                System.out.println("HDFC: Insufficient balance!");
            }
        } else {
            System.out.println("HDFC: Invalid account number!");
        }
        return 0.0;
	}
	
	public void balance(String accNumber)
	{
		if (this.accNumber.equals(accNumber)) 
		{
            System.out.println(balance);
        } 
		else 
		{
            System.out.println("HDFC: Invalid account number!");
        }
		
	}
	
	

}
