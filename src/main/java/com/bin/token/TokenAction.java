package com.bin.token;

import com.opensymphony.xwork2.ActionSupport;

public class TokenAction extends ActionSupport{

	private static final long serialVersionUID = 106029355947538274L;

	private String username ;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		Thread.sleep(2000);
		
		System.out.println(username);
		
		return SUCCESS ;
	}
}
