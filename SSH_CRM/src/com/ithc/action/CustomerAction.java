package com.ithc.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.Customer;
import com.ithc.bean.Dict;
import com.ithc.service.CustomerService;
import com.ithc.util.FastJsonUtil;
import com.ithc.util.PageBean;
import com.ithc.util.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String initAddUI() {

		return "initAddUI";
	}

	// 需要做文件上传
	private File upload;
	private String uploadFileName;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String save() throws Exception {

		if (uploadFileName != null) {

			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			// 目标路径
			String path = "D:/Tomcat/apache-tomcat-7.0.70/webapps/upload/";
			File file = new File(path + uuidname);
			FileUtils.copyFile(upload, file);
			customer.setFilePath(path + uuidname);
		}

		customerService.save(customer);

		return "save";
	}

	/**
	 * 显示客户
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

		// 创建离线查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

		// 拼接查询条件
		// 1.用名字查
		String customerName = customer.getCust_name();
		if (customerName != null && !customerName.isEmpty()) {
			criteria.add(Restrictions.like("cust_name", "%" + customerName + "%"));
		}

		// 2.用客户的级别查询
		Dict level = customer.getLevel();
		if (level != null && !level.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
		}

		// 3.用客户的信息来源查询
		Dict source = customer.getSource();
		if (source != null && !source.getDict_id().trim().isEmpty()) {
			criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
		}

		PageBean<Customer> page = customerService.findByPage(pageCode, pageSize, criteria);
		// 获取值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "page";
	}

	public String findAll() {

		List<Customer> list = customerService.findAll();

		String jsonString = FastJsonUtil.toJSONString(list);

		HttpServletResponse response = ServletActionContext.getResponse();

		FastJsonUtil.write_json(response, jsonString);

		return NONE;
	}

	/**
	 * 修改 1.先查询
	 */
	public String initUpdate() {

		customer = customerService.findById(customer.getCust_id());

		return "initUpdate";
	}

	/**
	 * 修改
	 */
	public String update() {
		customerService.update(customer);

		return "update";
	}

	/**
	 *  删除
	 */
	public String delete(){
		
		customer =  customerService.findById(customer.getCust_id());
		
		customerService.delete(customer);
		
		return "delete";
	}
	
	/**
	 *  行业统计
	 */
	
	public String findByIndustry(){
		
		List<Object[]> list =  customerService.findByIndustry();
		
		ActionContext.getContext().getValueStack().set("list",list);
		
		return "findByIndustry";
	}
	
	
	/**
	 *  信息来源
	 */
	public String findBySource(){
		List<Object[]> list = customerService.findBySource();
		
		ActionContext.getContext().getValueStack().set("list",list);
		return "findBySource";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
