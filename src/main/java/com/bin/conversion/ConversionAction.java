package com.bin.conversion;

import com.bin.conversion.converter.model.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ConversionAction extends ActionSupport implements ModelDriven<Customer> {

	private static final long serialVersionUID = 1L;
	private Customer model ;
	
	public String execute() {
		System.out.println("age:" + model.getAge());
		System.out.println("birth:" + model.getBirth());
		return "success" ;
	}

	@Override
	public Customer getModel() {
		model = new Customer() ;
		return model;
	}
}
