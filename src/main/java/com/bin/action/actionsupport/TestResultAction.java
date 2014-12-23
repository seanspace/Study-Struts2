package com.bin.action.actionsupport;

import com.opensymphony.xwork2.ActionSupport;

public class TestResultAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int number ;
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String execute() throws Exception {
		// 根据请求的参数number的值,返回对应的jsp页面.
		// 1.若number是3个整数,返回success.jsp页面.
		if (number % 3 == 0) {
			return SUCCESS ;
		}
		else if (number % 3 == 2) {
			return "index" ;
		}
		else if (number % 3 == 1) {
			return "login" ;
		} else {
			return "test" ;
		}
	}
	
}
