package com.bin.action.webresource;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {

	public String execute() {
		// 0.获取ActionContext对象,它是Action的上下文对象.里面也可以存属性 	
		ActionContext actionContext = ActionContext.getContext() ;
		
		// 1.获取application对应的Map,并向其中添加一个属性.通过actionContext的getApplication()方法获取application内置对象对应的map对像.
		Map<String, Object> application = actionContext.getApplication() ;
		application.put("applicationKey", "applicationValue");
		Object date = application.get("map") ;
//		System.out.println("date:" + date);
		
		// 2.session
		Map<String, Object> session = actionContext.getSession() ;
		session.put("sessionKey","sessionValue");
		
		System.out.println(session.getClass());
		if (session instanceof SessionMap) {
			SessionMap<String, Object> sMap = (SessionMap<String, Object>) session ;
			sMap.invalidate();
			System.out.println("session失效了.");
		}
		
		// 3.request:ActionContext中并没有提供getRequest方法来获取request对应的Map.需要手工调用get()方法,传入request字符串来获取.
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request") ;
		requestMap.put("requestKey", "requestValue") ;
		
		// 4.获取请求参数的Map,一个参数名得到的值是数组.对应的是request的getParamtersMap()方法
		// 注意:	1.getParameters的返回值为Map<String,Object>,而不是Map<String,String[]>
		//		2.paramters这个Map只能读,不能写入数据;如果写入,不报错,但不起作用.
		Map<String, Object> paramMetersMap = actionContext.getParameters() ;
		System.out.println(((String[])paramMetersMap.get("name"))[0]);
		
		
		return  "success" ;
	}
}
