package com.wipro.oops;

public class CITI implements BanksOps{

	private String accNumber;
	private double balance;
	
	public CITI(String accNumber) 
	 {
	        this.accNumber = accNumber;
	        this.balance = 0.0;
	  }
	
	@Override
	public void deposit(double amount, String accNumber) {
		
		 if (this.accNumber.equals(accNumber)) {
	            balance += amount;
	            System.out.println("Citi: Deposited ₹" + amount + " (+₹10 bonus) into account " + accNumber);
	        } else {
	            System.out.println("Citi: Invalid account number!");
	        }
		
		
	}

	@Override
	public double withdraw(double amount, String accNumber)
	{
		
		if (this.accNumber.equals(accNumber)) {
           
            if (amount  <= balance) {
                balance -= amount;
                System.out.println("Citi: Withdrawn ₹" + amount + " from account " + accNumber + " (₹5 fee deducted)");
                return amount;
            } else {
                System.out.println("Citi: Insufficient balance!");
            }
        } else {
            System.out.println("Citi: Invalid account number!");
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
            System.out.println("CITI: Invalid account number!");
        }
		
	}
	

}
