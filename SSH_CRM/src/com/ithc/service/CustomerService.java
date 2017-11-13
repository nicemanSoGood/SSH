package com.ithc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.Customer;
import com.ithc.util.PageBean;

public interface CustomerService {
	/**
	 *  保存客户信息
	 * @param customer
	 */
	void save(Customer customer);
	/**
	 *  分页查询
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
	/**
	 *  查询所有
	 * @return
	 */
	List<Customer> findAll();
	/**
	 *  修改之前先查询
	 * @param cust_id
	 * @return
	 */
	Customer findById(Long cust_id);
	/**
	 *  修改
	 * @param customer
	 */
	void update(Customer customer);
	/**
	 *  删除
	 * @param customer
	 */
	void delete(Customer customer);
	/**
	 *  行业统计
	 * @return
	 */
	List<Object[]> findByIndustry();
	/**
	 *  信息来源统计
	 * @return
	 */
	List<Object[]> findBySource();

}
