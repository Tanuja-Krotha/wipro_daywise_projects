package com.wipro.sbmvcdemo.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wipro.sbmvcdemo.moedel.User;

@Repository
public class UserRepository implements UserRepositoryI
{
	 @Override
	    public void save(User user) 
	 {
	        System.out.println("Saving user to database (simulated):");
	        System.out.println("Username: " + user.getUsername());
	        System.out.println("Email: " + user.getUserEmail());
	        System.out.println("Phone: " + user.getUserPhone());
	    }
}
