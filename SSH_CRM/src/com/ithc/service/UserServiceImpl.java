package com.ithc.service;

import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.User;
import com.ithc.dao.UserDao;
import com.ithc.util.MDUtils;
import com.ithc.util.State;
@Transactional
public class UserServiceImpl implements UserService{

	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 *  登入校验
	 */
	@Override
	public User login(User user) {
		String password = user.getUser_password();
		//用md5把密码加密
		user.setUser_password(MDUtils.md5(password));
		
		return userDao.login(user);
	}
	/**
	 *  ajax 注册校验
	 */
	@Override
	public boolean checkCode(String user_code) {
		
		return userDao.checkCode(user_code);
	}
	/**
	 * 注册保存
	 */
	@Override
	public void save(User user) {
		String password = user.getUser_password();
		user.setUser_password(MDUtils.md5(password));
		user.setUser_state(State.state());
		userDao.save(user);
	}

	
	
}
