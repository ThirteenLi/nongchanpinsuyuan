package com.gap.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.gap.domain.Customer;
import com.gap.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Customer customer);
	//根据id获得客户对象
	Customer getById(Long cust_id);
	//获得按行业统计客户数量
	List<Object[]> getIndustryCount();
	
	void saveCustomer(Customer customer);
	
	void deleteById(Long id_cus);
	
	//激活用户
	void modifyOpenAuthorization(Customer customer);
	
	//消费者登录
	Customer getCustomerByPhonePassword(Customer cus);
	
	//检查电话号码是否注册
	boolean getCustomerByPhone(String phoneNumber_cus);
}
