package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Visit;
import com.ithc.dao.VisitDao;
import com.ithc.util.PageBean;

@Transactional
public class VisitServiceImpl implements VisitService{

	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	/**
	 *  保存拜访
	 */
	@Override
	public void save(Visit visit) {
		visitDao.save(visit);
	}
	/**
	 *  查询拜访记录
	 */
	@Override
	public PageBean<Visit> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return visitDao.findByPage(pageCode, pageSize, criteria);
	}
	
	
	
	
}
