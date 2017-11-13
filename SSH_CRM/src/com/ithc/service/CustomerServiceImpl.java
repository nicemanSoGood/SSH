package com.ithc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Customer;
import com.ithc.dao.CustomerDao;
import com.ithc.util.PageBean;

@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	/**
	 *  保存客户信息
	 */
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	/**
	 *  分页查询
	 */
	@Override
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return customerDao.findByPage(pageCode, pageSize, criteria);
	}
	/**
	 *  查询所有
	 */
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	/**
	 *  修改之前先查询
	 */
	@Override
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}
	/**
	 *  修改
	 */
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}
	/**
	 *  行业统计
	 */
	@Override
	public List<Object[]> findByIndustry() {
		return customerDao.findByIndustry();
	}
	/**
	 *  信息来源统计
	 */
	@Override
	public List<Object[]> findBySource() {
		return customerDao.findBySource();
	}
	
}
