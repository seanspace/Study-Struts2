package com.bin.validation;

import com.opensymphony.xwork2.ActionSupport;

public class TestValidationAction extends ActionSupport {

	private static final long serialVersionUID = -5999935457133650588L;

	private String password ;
	private String password2 ;
	private int age ;
	private int count ;
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("age:" + age);
		
		return SUCCESS
				
				;
	}
}
