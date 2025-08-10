package com.wiproA.mockitodemov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeInsert {
	public static void insert()
	{
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into employee(emp_name,department) values (?,?)");
		ps.setString(1,"Tanuja");
		ps.setString(2,"EEE");
		ps.executeUpdate();
		con.close();
		
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	}
	}
	
	public static void allEmployee()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				 int id = rs.getInt("id");
	             String name = rs.getString("emp_name");
	             String dept = rs.getString("department");
	             System.out.println("ID: " + id + ", Name: " + name + ", Department: " + dept);
			}
			rs.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args)  {
		
		
		insert();
		allEmployee();

	}

}
