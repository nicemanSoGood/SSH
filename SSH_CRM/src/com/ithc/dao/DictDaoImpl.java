package com.ithc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.Dict;

public class DictDaoImpl extends HibernateDaoSupport implements DictDao{

	/**
	 *  根据类别代码查询信息
	 */
	@Override
	public List<Dict> findByCode(String dict_type_code) {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code = ?",dict_type_code);
	}

}
