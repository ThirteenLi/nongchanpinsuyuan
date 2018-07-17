package com.gap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Farmer;



public interface FarmerDao extends BaseDao<Farmer> {
	//按照行业统计客户数量
	List<Object[]> getIndustryCount();
	
	//通过手机号码查询农户
	public Farmer getByPhoneNumber(final String phoneNumber);
	
	//通过身份证号查询农户
	public Farmer getByIDCardNumber(final String IDCardNum_nh);
}
