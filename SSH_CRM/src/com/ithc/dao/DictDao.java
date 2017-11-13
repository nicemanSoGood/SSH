package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Dict;

public interface DictDao {

	/**
	 * 根据类别代码查询信息 006 | 002
	 * @param dict_type_code
	 * @return
	 */
	List<Dict> findByCode(String dict_type_code);

}
