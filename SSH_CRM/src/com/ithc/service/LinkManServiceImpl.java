package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Linkman;
import com.ithc.dao.LinkManDao;
import com.ithc.util.PageBean;

@Transactional
public class LinkManServiceImpl implements LinkManService{
	
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	/**
	 *  添加联系人
	 */
	@Override
	public void save(Linkman linkMan) {
		linkManDao.save(linkMan);
	}
	/**
	 *  联系人列表
	 */
	@Override
	public PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		return linkManDao.findByPage(pageCode, pageSize, criteria);
	}
	/**
	 * 用id查询
	 */
	
	@Override
	public Linkman findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);
	}
	/**
	 *  修改
	 */
	@Override
	public void update(Linkman linkMan) {
		linkManDao.update(linkMan);
	}
	/**
	 *  删除
	 */
	@Override
	public void delete(Linkman linkMan) {
		linkManDao.delete(linkMan);
	}
	

}
