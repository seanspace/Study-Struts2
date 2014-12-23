package com.bin.action.app;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware,ApplicationAware{
	private String username ;
	public void setUsername(String username) {
		this.username = username;
	}
	public String execute() {
		// 把用户信息存入Session域中.
		//1.获取session,通过RequestAware接口
		
		// 2.获取登陆信息
		
		// 3.把用户信息存入session
		session.put("username", username) ;
		
		// 在线人数+1
		// 1.获取当前的在线人数
		Integer count = (Integer) application.get("count") ;
		if (count == null) {
			count = 0 ;
		}
		// 2.是当前的在线人数 + 1
		count++ ;
		application.put("count", count) ;
		return "login-success" ;
	}
	
	public String logout() {
		Integer count = (Integer) application.get("count") ;
		
		if (count != null && count > 0) {
			count-- ;
			application.put("count", count) ;
		}
		((SessionMap)session).invalidate();
		
		return "logout-success" ;
	}

	private Map<String, Object> session ;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
	private Map<String, Object> application ;
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application ;
	}
}
