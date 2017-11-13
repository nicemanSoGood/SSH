package com.ithc.service;

import com.ithc.bean.User;

public interface UserService {
	/**
	 *  登入校验
	 * @param user
	 * @return
	 */
	User login(User user);
	/**
	 *  ajax注册校验
	 * @param user_code
	 * @return
	 */
	boolean checkCode(String user_code);
	/**
	 *  注册保存
	 * @param user
	 */
	void save(User user);

}
