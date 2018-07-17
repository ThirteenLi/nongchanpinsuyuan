package com.gap.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Checker;

import com.gap.utils.PageBean;

public interface CheckerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Checker checker);
	//根据id获得客户对象
	Checker getById(Long id_zjy);
	//获得按行业统计客户数量
	List<Object[]> getIndustryCount();
	
	void saveCustomer(Checker checker);
	
	void deleteById(Long id_zjy);
	
	//激活用户
	void modifyOpenAuthorization(Checker checker);
	
	//消费者登录
	Checker getCheckerByUserNamePassword(Checker checker);
}
