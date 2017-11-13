package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.Visit;
import com.ithc.util.PageBean;

public interface VisitService {
	/**
	 *  保存拜访
	 * @param visit
	 */
	void save(Visit visit);
	/**
	 *  查询拜访记录
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);


}
