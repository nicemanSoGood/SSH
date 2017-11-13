package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.Linkman;
import com.ithc.util.PageBean;

public interface LinkManService {
	/**
	 * 添加联系人 
	 * @param linkMan
	 */
	void save(Linkman linkMan);
	/**
	 *  联系人列表
	 * @param pageCode
	 * @param pageSize
	 * @param criteria
	 * @return
	 */
	PageBean<Linkman> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
	/**
	 *  用id查询
	 * @param lkm_id
	 * @return
	 */
	Linkman findById(Long lkm_id);
	/**
	 *  修改
	 * @param linkMan
	 */
	void update(Linkman linkMan);
	/**
	 *  删除
	 * @param linkMan
	 */
	void delete(Linkman linkMan);
	
	

}
