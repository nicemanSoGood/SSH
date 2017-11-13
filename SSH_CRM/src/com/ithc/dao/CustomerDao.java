package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Customer;

public interface CustomerDao extends BaseDao<Customer>{
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
