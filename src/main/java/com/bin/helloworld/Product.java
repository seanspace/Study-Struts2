package com.bin.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bin.tag.Person;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product implements RequestAware,SessionAware{
	private Integer productId ;
	private String productName ;
	private String productDesc ;
	private String productPrice ;
	
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice=" + productPrice + "]";
	}
	
	public String save(){
		System.out.println("sava method" + this);
		// 1.首先获取值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack() ;
		// 2.创建Test对象,并为其属性赋值;
		Test oTest = new Test() ;
		oTest.setProductDesc("AAAAAAAAA");
		oTest.setProductName("111111111111");
		// 3.把Test对象压入栈顶
		valueStack.push(oTest);
		
		sessionMap.put("product", this) ;
		requestMap.put("test", oTest) ;
		
		//int i = 10/0 ;
		
		
		return "details" ;
	}
	
	private List<Person> persons = new ArrayList<Person>() ;
	

	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public String testTag(){
		this.productId = 1001 ;
		this.productName = "cpu" ;
		this.productDesc = "intel" ;
		this.productPrice = "1200" ;
		
		persons.add(new Person("AA",10)) ;
		persons.add(new Person("BB",20)) ;
		persons.add(new Person("CC",30)) ;
		persons.add(new Person("DD",40)) ;
		persons.add(new Person("EE",50)) ;
		
		
		return "success" ;
	}
	
	private Map<String, Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session ;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	private Map<String, Object> requestMap ;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request ;
	}
	public Map<String, Object> getRequestMap() {
		return requestMap;
	}
	
	
}
