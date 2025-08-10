package com.wipro.panmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pan")
public class Pan 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="pan_number")
	String panNumber;
	
	public Pan()
	{
		super();
	}

	
	public Pan(int id, String userName, String panNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.panNumber = panNumber;
	} 
	
	public Pan(String userName, String panNumber) {
		super();
		this.userName = userName;
		this.panNumber = panNumber;
	}
	


	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	@Override
	public String toString() {
		return "Pan [id=" + id + ", userName=" + userName + ", panNumber=" + panNumber + "]";
	}
	
	
}
