package com.ithc.fastjson;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestPerson extends ActionSupport implements ModelDriven<Person> {
	
	private Person p = new Person();

	@Override
	public Person getModel() {
		return p;
	}
	
	
	public String testPerson(){
		
		System.out.println(p);
		
		return null;
	}

}
