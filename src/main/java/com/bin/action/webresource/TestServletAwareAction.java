package com.bin.action.webresource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * 通过ServletXxxAware接口的方式可以由Struts2注入需要的Servlet相关对象.
 * 
 *
 */
public class TestServletAwareAction implements ServletRequestAware,ServletContextAware,ServletResponseAware{
	@Override
	public void setServletResponse(HttpServletResponse response) {
		 
	}

	@Override
	public void setServletContext(ServletContext context) {
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
	}
	
	public String excute(){
		
		
		return "success" ;
	}


}
