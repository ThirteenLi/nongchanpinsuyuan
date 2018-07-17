package com.gap.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Agent;
import com.gap.utils.PageBean;

public interface AgentService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Agent agent);
	//根据id获得客户对象
	Agent getById(Long id_dls);
	//获得按行业统计客户数量
	List<Object[]> getIndustryCount();
	
	void saveAgent(Agent agent);
	
	void deleteById(Long id_dls);
	
	//代理商登录
	Agent getAgentByPhonePassword(Agent agent);
	
	//激活代理商权限
	void modifyOpenAuthorization(Agent agent1);
	
	
	//代理商修改密码
	void modifyFarmerPassword(Agent agent, String newPassword);
}
