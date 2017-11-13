package com.ithc.fastjson;

public class Role {
	
	private String rname;
	
	private Person person;
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Role [rname=" + rname + ", person=" + person + "]";
	}
}
