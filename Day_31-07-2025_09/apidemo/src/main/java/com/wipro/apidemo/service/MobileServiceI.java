package com.wipro.apidemo.service;

import java.util.List;

import com.wipro.apidemo.model.Mobile;

public interface MobileServiceI {
	
	public Mobile addMobile(Mobile mobile);
	
	public List<Mobile> getAllMobiles();
	
	public Mobile getMobileById(int id);
	
	public Mobile updateMobile(Mobile mobile, int id);
	
	public String deleteMobile(int id);

}
