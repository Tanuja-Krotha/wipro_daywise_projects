package com.wipro.sbmvcdemo.moedel;

public class User {
	private String username;
    private String userEmail;
    private String userPhone;
	
    public User()
    {
    	super();
    }
    public User(String username, String userEmail, String userPhone) {
		super();
		this.username = username;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
	}
    
    
    

}
