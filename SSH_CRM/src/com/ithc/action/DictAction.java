package com.ithc.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ithc.bean.Dict;
import com.ithc.service.DictService;
import com.ithc.util.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class DictAction extends ActionSupport implements ModelDriven<Dict>{

	private Dict dict = new Dict();
	@Override
	public Dict getModel() {
		return dict;
	}

	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	
	public String findByCode(){
		System.out.println(dict.getDict_type_code()+"......");
		//006 | 002
		List<Dict> list = dictService.findByCode(dict.getDict_type_code());
		
		String jsonString = FastJsonUtil.toJSONString(list);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		FastJsonUtil.write_json(response, jsonString);
		
		return NONE;
	}
	
	
}
