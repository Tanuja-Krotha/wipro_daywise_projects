package com.wipro.apidemo.repo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.wipro.apidemo.model.Mobile;

@Repository
public class MobileRepo {
	
	List<Mobile> mobileList=new CopyOnWriteArrayList<>();
	
	public void addMobile(Mobile mobile)
	{
		mobileList.add(mobile);
	}
	
	public List<Mobile> findAll()

	{

		return mobileList;

	}
	
	public Optional<Mobile> getMobileById(int id)
	{
        return mobileList.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }	
	
	 public boolean deleteMobile(int id) 
	 {
	        return mobileList.removeIf(m -> m.getId() == id);
	 }
	 
	 public boolean updateMobile(int id, Mobile updatedMobile) {
		    for (Mobile existingMobile : mobileList) {
		        if (existingMobile.getId() == id) 
		        {
		            existingMobile.setBrand(updatedMobile.getBrand());
		            existingMobile.setModelNumber(updatedMobile.getModelNumber());
		            existingMobile.setPrice(updatedMobile.getPrice());
		            return true;
		        }
		    }
		    return false;
		}


}
