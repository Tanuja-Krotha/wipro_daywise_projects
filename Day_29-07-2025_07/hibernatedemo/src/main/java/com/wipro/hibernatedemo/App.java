package com.wipro.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.hibernate.repo.PanRepo;
import com.wipro.hibernate.util.HibernateUtil;
import com.wipro.panmodel.Pan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int choice=0;
    	do {
    	System.out.println("--Menu---");
    	System.out.println("1.--Create Pan Record---");
    	System.out.println("2.--Find by Pan ID---");
    	System.out.println("3.--Update Pan Record---");
    	System.out.println("4.--Delete Pan By id---");
    	System.out.println("5.--Find All Pan Records---");
    	System.out.println("6.--Find All Pan User Names---");
    	System.out.println("7.--Find By Pan Number---");
    	System.out.println("9.--Exit---");
    	Scanner sc= new Scanner(System.in);    	
    	  choice= sc.nextInt();
    	  
    	
	    	switch(choice)
	    	{
	    		case 1:
	    			PanRepo.createPan();
	    		break;
	    		case 2:
	    			System.out.println("Please enter Pan ID:");
	    			int id= sc.nextInt();
	    			Pan p = PanRepo.findById(id);
	    			System.out.println(p);
	    			break;
	    		case 3:
	    			PanRepo.updatePan();
	    			break;
	    			
	    		case 4:
	    			 
	    			System.out.println("Please enter Pan ID:");
	    			int id1= sc.nextInt();
	    			PanRepo.deleteById(id1);
	    			break;
	    			
	    		case 5:
	    			List<Pan> list=PanRepo.findAll();
	    			System.out.println(list);
	    			break;
	    		
	    		case 6:
	    			List<String> userNameList = PanRepo.findAllUserNames();
	    			System.out.println(userNameList);
	    			break;
	    		case 7:
	    			System.out.println("Please enter Pan Number");
	    			String panNumber=sc.next();
	    			Pan pan= PanRepo.findByPanNumber(panNumber);
	    			System.out.println(pan);
	    			break;
	    		case 9:
	    			return;
	    		
	    		default:
	    			System.out.println("Invalid option please try again");
	    			break;
	    	
	    	 }
    
        	 
    	}while(choice!=9); 
    }
}
