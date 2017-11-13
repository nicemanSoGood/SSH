package com.ithc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Dict;
import com.ithc.dao.DictDao;

@Transactional
public class DictServiceImpl implements DictService {

	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}



	/**
	 * 根据类别代码查询信息 006|002
	 */
	@Override
	public List<Dict> findByCode(String dict_type_code) {
		return dictDao.findByCode(dict_type_code);
	}

}
