package com.ithc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.util.PageBean;

/**
 *  以后所有的Dao层接口需要继承这个接口
 * @author Administrator
 * @param <T>
 */
public interface BaseDao<T> {
	
	public void save(T t);
	
	public void delete(T t);
	
	public void update(T t);

	public T findById(Long id);
	
	public List<T> findAll();
	
	public PageBean<T> findByPage(Integer pageCode,Integer pageSize,DetachedCriteria criteria);
	
}
