package com.bin.action.wildcard;

public class UserAction {
	public String save(){
		System.out.println("save");
		
		
		return "save-success" ;
	}
	public String update(){
		
		System.out.println("update");
		return "update-success" ;
	}
	public String delete(){
		System.out.println("delete");
		
		return "delete-success" ;
	}
	public String query(){
		System.out.println("query");
		
		return "query-success" ;
	}
	
	public String test(){
		
		System.out.println("test");
		
		return "query-success" ;
	}

}
