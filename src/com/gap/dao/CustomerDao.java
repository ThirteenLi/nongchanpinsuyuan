package com.gap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.gap.domain.Customer;


public interface CustomerDao extends BaseDao<Customer> {
	//按照行业统计客户数量
	List<Object[]> getIndustryCount();
	
	public Customer getByUserCode(final String usercode);
}
