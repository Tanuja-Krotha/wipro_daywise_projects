package com.wipro.sbmvcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.sbmvcdemo.moedel.User;
import com.wipro.sbmvcdemo.repo.UserRepositoryI;

@Service
public class UserService implements UserServiceI  {
	
	
	@Autowired
    private UserRepositoryI userRepositoryI;

    @Override
    public void registerUser(User user) {
        
        userRepositoryI.save(user);
    }

}
