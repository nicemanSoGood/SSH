package com.ithc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ithc.bean.Customer;
import com.ithc.util.PageBean;

@SuppressWarnings("all")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
	/**
	 *  行业统计
	 */
	@Override
	public List<Object[]> findByIndustry() {
		/*
		  select
        dict1_.dict_item_name as col_0_0_,
        count(*) as col_1_0_ 
    from
        cst_customer customer0_ 
    inner join
        base_dict dict1_ 
            on customer0_.cust_industry=dict1_.dict_id 
    group by
        customer0_.cust_industry
		 */
		
		// SELECT d.`dict_item_name`,COUNT(*) FROM cst_customer c INNER JOIN base_dict d ON d.`dict_id` = c.`cust_industry` GROUP BY d.`dict_id`;
				//定义hql 
				String hql = "select "
						+ "c.industry.dict_item_name,count(*) "
						+ "from Customer c "
						+ "inner join "
						+ "c.industry "
						+ "group by "
						+ "c.industry";
		
		return (List<Object[]>) this.getHibernateTemplate().find(hql);
	}
	/**
	 *  信息来源统计
	 */
	@Override
	public List<Object[]> findBySource() {
		/*
		 * select
        dict1_.dict_item_name as col_0_0_,
        count(*) as col_1_0_ 
    from
        cst_customer customer0_ 
    inner join
        base_dict dict1_ 
            on customer0_.cust_source=dict1_.dict_id 
    group by
        customer0_.cust_source
		 */
		
		// select * from cst_customer c ,base_dict d where d.dict = c.cust_source
				//分组查询 ： select * from cst_customer c ,base_dict d where d.dict = c.cust_source group by d.dict
				// 查询内容 :  SELECT d.`dict_item_name`,COUNT(*) FROM cst_customer c INNER JOIN base_dict d ON d.`dict_id` = c.`cust_source` GROUP BY d.`dict_id`;
				//定义hql
				String hql = "select "
						+ "c.source.dict_item_name,count(*) "
						+ "from Customer c "
						+ "inner join "
						+ "c.source "
						+ "group by "
						+ "c.source";
		return (List<Object[]>) this.getHibernateTemplate().find(hql);
	}


	
	
	
	
	
	
}
