package com.wipro.hibernate.repo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import com.wipro.hibernate.util.HibernateUtil;
import com.wipro.panmodel.Pan;

public class PanRepo
{
	public static void updatePan()
	{
		Scanner sc= new Scanner(System.in); 
    	
    	System.out.println("Please enter pan id");
    	int id= sc.nextInt();
    	System.out.println("Please enter username name");
    	String userName= sc.next();
    	System.out.println("Please enter pannumber name");
    	String panNumber= sc.next();
    	Pan p = new Pan(id,userName,panNumber);
    	save(p);
	}

	public static void createPan()
    {
    	Scanner sc= new Scanner(System.in); 
    	
    	System.out.println("Please enter pan id");
    	int id= sc.nextInt();
    	System.out.println("Please enter username name");
    	String userName= sc.next();
    	System.out.println("Please enter pannumber name");
    	String panNumber= sc.next();
    	Pan p = new Pan(id,userName,panNumber);
    	save(p);
    	
    }

	private static void save(Pan p) {
		
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction transaction=session.beginTransaction();
    	if(p.getId()!=0)
    	{
    		Pan p1=findById(p.getId());
    		p1.setUserName(p.getUserName());
    		p1.setPanNumber(p.getPanNumber());
    		session.persist(p1);
    	}
		
	}

	public static Pan findById(int id) 
	{
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction transaction=session.beginTransaction();
    	Pan p =session.find(Pan.class, id);
    	return p;
	}
	
	 
	public static Pan deleteById(int id)
	    {
	     	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	Pan p=session.find(Pan.class, id);
	    	session.remove(p);
	    	transaction.commit();
	    	return p;
	    	
	    }
	
	public static List<Pan> findAll()
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="from Pan";//select * from movie
	    	Query query=session.createQuery(hqlQuery);
	    	List<Pan> list=query.list();
	    	return list;
	    	
	    }
	 
	 
	 
	 public static List<String> findAllPanNumbers()
	    {
	    	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="SELECT panNumber from Pan";
	    	Query query=session.createQuery(hqlQuery);
	    	List<String> list=query.list();
	    	return list;   	    	
	    } 
	 
	 public static Pan findByPanNumber(String PanNumber)
	    {
	     	Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	Pan p=session.find(Pan.class, PanNumber);
	    	return p;
	    	
	    }

	 public static List<String> findAllUserNames() {
		 Session session= HibernateUtil.getSessionFactory().getCurrentSession();
	    	Transaction transaction=session.beginTransaction();
	    	//sql=>db tables
	    	//hql->java entities
	    	String hqlQuery="SELECT userName from Pan";
	    	Query query=session.createQuery(hqlQuery);
	    	List<String> list=query.list();
	    	return list;   	  
	 }
	 
	
	
}
