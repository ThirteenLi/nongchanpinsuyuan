package com.gap.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Farmer;
import com.gap.utils.FarmerRepository;
import com.gap.utils.PageBean;

public interface FarmerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//管理员保存客户方法
	void save(Farmer farmer);
	
	//根据id获得客户对象
	Farmer getById(Long id_nh);
	
	//获得按行业统计客户数量
	List<Object[]> getIndustryCount();
	
	//农户注册方法
	void saveNewFarmer(Farmer customer);
	
	//根据id删除农户
	void deleteById(Long id_nh);
	
	//登录
	Farmer getFarmerByPhonePassword(Farmer farmer);

	//激活农户权限
	void modifyOpenAuthorization(Farmer farmer1);
	
	
	//修改农户信息
	void modifyFarmerInfo(Farmer farmer);
	
	
	//修改密码
	void modifyFarmerPassword(Farmer farmer, String newPassword);
	

}
