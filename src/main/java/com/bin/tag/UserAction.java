package com.bin.tag;

import java.util.Arrays;
import java.util.List;


public class UserAction {

	private String userID ;
	private String username ;
	private String password ;
	private String desc ;
	private String married ;
	private String gender ;
	private List<String> city ;
	private String age ;
	
	
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String save(){
		System.out.println(this);
		
		return "input" ;
	}
	
	public UserAction() {
	}
	@Override
	public String toString() {
		return "UserAction [userID=" + userID + ", username=" + username + ", password=" + password + ", desc=" + desc + ", married=" + married + ", gender=" + gender + ", city=" + city + ", age=" + age + "]";
	}
	
	
	
	
}
