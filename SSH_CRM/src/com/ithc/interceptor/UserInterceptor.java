package com.ithc.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ithc.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 *  用户的拦截器
 *  判断用户是否登入
 *  如果登入就执行下一个拦截器，如果没有登入就跳回登入页面(不能所有的请求都拦截，login 与 register方法不拦截)
 *  继承指定的拦截器
 * @author Administrator
 *
 */
public class UserInterceptor extends MethodFilterInterceptor{
	private static final long serialVersionUID = 1L;
	/**
	 *  拦截目标 action的方法
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取session
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("existUser");
		if(user == null){
			return "login";
		}
		//执行下一个拦截器
		return invocation.invoke();
	}

	
	
}
