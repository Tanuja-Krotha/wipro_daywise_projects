package com.wipro.userservice.dto;

public class Token {
	String token;

	
	public Token() {
		super();
	}


	public Token(String token) {
		super();
		this.token = token;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	@Override
	public String toString() {
		return "Token [token=" + token + "]";
	}
	
	
}
