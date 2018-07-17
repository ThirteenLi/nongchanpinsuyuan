package com.gap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Checker;



public interface CheckerDao extends BaseDao<Checker> {
	//按照行业统计客户数量
	List<Object[]> getIndustryCount();
	
	public Checker getByUserCode(final String usercode);
}
