package com.ithc.fastjson;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ithc.bean.Customer;


public class TestFastJson {
	
	@Test
	public void run1(){
		
		Customer customer = new Customer();
		customer.setCust_name("美美");
		customer.setCust_mobile("123456798");
		String jsonString = JSON.toJSONString(customer);
		System.out.println(jsonString);
		
	}
	@Test
	public void run2(){
		List<Customer> list = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		customer.setCust_name("美美");
		customer.setCust_mobile("123456798");
		list.add(customer);
		Customer customer2 = new Customer();
		customer2.setCust_name("美美2");
		customer2.setCust_mobile("1234567982");
		list.add(customer2);
		
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
	}
	
	/**
	 *  禁止循环引用
	 */
	
	@Test
	public void run3(){
		List<Customer> list = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		customer.setCust_name("美美");
		customer.setCust_mobile("123456798");
		list.add(customer);
		
		list.add(customer);
		
		/*String jsonString = JSON.toJSONString(list);*/
		
		String jsonString = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(jsonString);
	}
	@Test
	public void run4(){
		Person p = new Person();
		p.setPname("小王");
		
		Role role = new Role();
		role.setRname("管理员");
		
		p.setRole(role);
		
		role.setPerson(p);
		
		String jsonString = JSON.toJSONString(role,SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(jsonString);
	}
	
	
	
	
	
	
	
	
	
	
	

}
