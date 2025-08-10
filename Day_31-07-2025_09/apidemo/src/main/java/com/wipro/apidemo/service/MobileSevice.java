package com.wipro.apidemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.apidemo.model.Mobile;
import com.wipro.apidemo.repo.MobileRepo;
@Service
public class MobileSevice implements MobileServiceI {
	@Autowired
	MobileRepo mobileRepo;
	
	@Override
	public Mobile addMobile(Mobile mobile) 
	{
		mobileRepo.addMobile(mobile);
        return mobile;
	}

	@Override
	public List<Mobile> getAllMobiles() 
	{
		return mobileRepo.findAll();
	}

	@Override
	public Mobile getMobileById(int id) 
	{
		return mobileRepo.getMobileById(id).orElse(null);
	}

	@Override
	public Mobile updateMobile(Mobile mobile, int id) {
		boolean updated = mobileRepo.updateMobile(id, mobile);
        return updated ? mobile : null;
	}

	
	@Override
	public String deleteMobile(int id) 
	{
		boolean deleted = mobileRepo.deleteMobile(id);
        return deleted ? "Mobile deleted successfully" : "Mobile not found";
    }
	
	

}
