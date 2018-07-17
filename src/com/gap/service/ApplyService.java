package com.gap.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Agent;
import com.gap.domain.Apply;
import com.gap.utils.PageBean;

public interface ApplyService {
	
	
	//【农场管理】农户添加变更农场申请
	public void saveNHChangeFarmApply(Apply farmerApply);
	
	//【农场管理】农户查询变更申请列表
	public PageBean getApplyPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//【农户管理】农户联系管理员
	public void saveFarmerApply(Apply farmerApply);

	//【代理点管理】代理商变更代理点申请
	public void saveDLSChangeShopApply(Apply agentApply);
	
	//【代理商管理】代理商联系管理员
	public void saveAgentApply(Apply agentApply);

	//管理员
	public PageBean getPageBean(DetachedCriteria dc, Integer page, Integer rows);

	//管理员删除
	public void deleteById(Long id_message);

	//管理员根据id获得
	public Apply getById(Long id_message);

	//管理员保存
	public void save(Apply myapply);

	
	
	
}
