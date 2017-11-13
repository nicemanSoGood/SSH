package com.ithc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ithc.bean.User;
import com.ithc.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	// 模型驱动需要把对象手动new出来
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String viCode;
	public void setViCode(String viCode) {
		this.viCode = viCode;
	}

	/**
	 *  登入校验
	 * @return
	 */
	public String login(){
		User exitUser = userService.login(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String vcode = (String) session.getAttribute("validateCode");
//		System.out.println(vcode);
		if(exitUser == null || !vcode.equalsIgnoreCase(viCode)){
			//如果用户不存在跳转登入页面
			return "login";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser",exitUser);
		}
		
		return "loginOk";
	}
	
	/**
	 *  登出
	 */
	public String exit(){
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
		return "exit";
	}
	
	
	/**
	 *  注册校验
	 */
	public String register(){
		
		userService.save(user);
		
		return "login";
	}
	
	
	/**
	 *  Ajax 校验
	 * @throws Exception 
	 */
	
	public String checkCode() throws Exception{
		//查询注册的名字
		String user_code = user.getUser_code();
		boolean boo = userService.checkCode(user_code);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		if(boo){
			//不存在可以注册
			printWriter.print("yes");
			
		}else{
			//存在不能注册
			printWriter.print("no");
		}
		return NONE;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
