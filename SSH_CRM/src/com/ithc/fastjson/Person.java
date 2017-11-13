package com.ithc.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {
	
	@JSONField(serialize=false)
	private Role role;
	
	private String pname;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Person [role=" + role + ", pname=" + pname + "]";
	}
}
