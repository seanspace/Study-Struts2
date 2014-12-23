package com.bin.action.webresource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction {

	public String execute(){
		/**
		 * ServletActioinContext:可以从中获取当前Action对象需要的一切Servlet API相关对象.
		 * 常用方法:
		 * 1.ServletActionContext.getRequest() ;
		 * 2.ServletActionContext.getRequest().getSession() ;
		 * 3.ServletActionContext.getServletContext() ;
		 */
		HttpServletRequest request = ServletActionContext.getRequest() ;
		HttpSession session = ServletActionContext.getRequest().getSession() ;
		//HttpSession session = request.getSession() ;
		ServletContext servletContext = ServletActionContext.getServletContext() ;
		
		System.out.println("execute");
		
		
		return "success" ;
	}
}
