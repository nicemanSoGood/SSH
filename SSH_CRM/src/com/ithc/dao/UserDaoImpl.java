package com.ithc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	/**
	 *  登入校验
	 */
	@Override
	public User login(User user) {
		
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password=? and user_state = ?",user.getUser_code(),user.getUser_password(),"1");
		//判断集合是否为空
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 *  ajax 注册校验
	 */
	@Override
	public boolean checkCode(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?",user_code);
		
		if(list!=null && list.size()>0){
			//存在
			return false;
		}
		//不存在
		return true;
	}
	/**
	 *  注册保存
	 */
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}
	
}
