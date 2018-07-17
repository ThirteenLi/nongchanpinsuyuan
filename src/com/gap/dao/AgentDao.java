package com.gap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Agent;




public interface AgentDao extends BaseDao<Agent> {
	//按照行业统计客户数量
	List<Object[]> getIndustryCount();
	
	public Agent getByUserCode(final String usercode);
}
