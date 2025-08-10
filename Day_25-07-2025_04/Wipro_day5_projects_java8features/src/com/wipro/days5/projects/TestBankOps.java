package com.wipro.days5.projects;

public class TestBankOps 
	{
		public static void main(String[] args) 
			{
				BankOps savingsAccount = new BankOps()
						{
							@Override
							public void deposit(double amount) 
							{
								
								 System.out.println("Depositing ₹" + amount + " to Savings Account.");

								
							}
					
						};
					BankOps currentAccount = new BankOps() 
					{
					            @Override
					        public void deposit(double amount) 
					            {
					                System.out.println("Depositing ₹" + amount + " to Current Account.");
					            }
					  };
					  savingsAccount.deposit(5000.0);
				      currentAccount.deposit(10000.0);
			}

	}
