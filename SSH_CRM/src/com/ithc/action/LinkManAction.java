package com.ithc.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.Customer;
import com.ithc.bean.Dict;
import com.ithc.bean.Linkman;
import com.ithc.service.LinkManService;
import com.ithc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class LinkManAction extends ActionSupport implements ModelDriven<Linkman> {
	private static final long serialVersionUID = 1L;
	private Linkman linkMan = new Linkman();

	@Override
	public Linkman getModel() {
		return linkMan;
	}

	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public String initAddUI() {

		return "initAddUI";
	}

	/**
	 * 添加联系人
	 */
	public String save() {

		linkManService.save(linkMan);

		return "save";
	}

	/**
	 * 联系人列表
	 */
	// 属性驱动
	// 当前页
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

	public String findByPage() {
		System.out.println(0);
		// 创建离线查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		
		// 拼接查询条件
				// 1.用名字查
				String linkmanName = linkMan.getLkm_name();
				if (linkmanName != null && !linkmanName.isEmpty()) {
					criteria.add(Restrictions.like("lkm_name", "%"+linkmanName+"%"));
				}
				
				Customer customer = linkMan.getCustomer();
				if (customer != null && customer.getCust_id()!=null) {
					criteria.add(Restrictions.eq("customer.cust_id", customer.getCust_id()));
				}
				
				// 2.用客户的级别查询
			/*	Dict level = customer.getLevel();
				if (level != null && !level.getDict_id().trim().isEmpty()) {
					criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
				}*/
		
		
		
		
		PageBean<Linkman> page = linkManService.findByPage(pageCode,pageSize,criteria);
		
		List<Linkman> beanList = page.getBeanList();
		
		for (Linkman linkman : beanList) {
			System.out.println(linkman);
		}
		
		//获取值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page",page);

		return "page";
	}
	/**
	 *  修改联系人信息
	 *  修改之前先查询
	 */
	public String initUpdate(){
		
		linkMan =  linkManService.findById(linkMan.getLkm_id());
		
		return "initUpdate";
	}
	/**
	 *  修改
	 */
	public String update(){
		linkManService.update(linkMan);
		
		
		return "update";
	}
	
	/**
	 *  删除
	 */
	public String delete(){
		
		linkMan =  linkManService.findById(linkMan.getLkm_id());
		
		linkManService.delete(linkMan);
		
		return "delete";
	}
	
	
	
	
	
	
	

}
