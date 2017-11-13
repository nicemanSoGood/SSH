package com.ithc.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.User;
import com.ithc.bean.Visit;
import com.ithc.service.VisitService;
import com.ithc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

	private Visit visit = new Visit();

	@Override
	public Visit getModel() {
		return visit;
	}
	
	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	public String initAddUI(){
		
		return "initAddUI";
	}
	
	/**
	 *  保存客户拜访记录
	 */
	public String save(){
		
		//获取登入的用户
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		if(user == null){
			return "login";
		}
		
		visit.setUser(user);
		
		visitService.save(visit);
		
		return "save";
	}
	
	/**
	 *  查询拜访列表
	 * @return
	 */
	private Integer pageCode = 1;

	public void setPageCode(Integer pageCode) {
		if (pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	// 每页显示的条数
	private Integer pageSize = 2;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 查询时间的属性驱动 
	 * @return
	 */
	private String beginDate;
	private String endDate;
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String findByPage(){
		
		User user  = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user == null){
			return "login";
		}
		//创建离线条件查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		
		String vname = visit.getVisit_interviewee();
		System.out.println(vname + ".....");
		/**
		 *  用名字查询
		 */
		if(vname !=null && !vname.trim().isEmpty()){
			criteria.add(Restrictions.like("visit_interviewee","%"+vname+"%"));
		}
		
		/**
		 *  用时间查询
		 */
		if(beginDate!=null && !beginDate.trim().isEmpty()){
			criteria.add(Restrictions.ge("visit_time", beginDate));
		}
		if(endDate!=null && !endDate.trim().isEmpty()){
			criteria.add(Restrictions.le("visit_nexttime", endDate));
		}
		
		
		//添加查询的条件
		criteria.add(Restrictions.eq("user.user_id",user.getUser_id()));
		
		PageBean<Visit> page =  visitService.findByPage(pageCode,pageSize,criteria);
		
		List<Visit> beanList = page.getBeanList();
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page",page);
		
		return "page";
	}
	
}
