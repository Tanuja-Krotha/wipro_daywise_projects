package com.wipro.test;
import com.wipro.oops.BanksOps;
import com.wipro.oops.CITI;
import com.wipro.oops.HDFC;

public class BankTest {

	public static void main(String[] args) {


		//BanksOps hdfc = new HDFC("HDFC123");
		//BanksOps citi = new CITI("CITI123");
		
		
		HDFC hdfc = new HDFC("HDFC123");
		CITI citi = new CITI("CITI123");
		
		hdfc.deposit(1000,"HDFC123");
		hdfc.withdraw(10,"HDFC123");
		hdfc.balance("HDFC123");
		
		citi.deposit(10000,"CITI123");
		citi.withdraw(500,"CITI123");
		citi.balance("CITI123");
		

	}

}
