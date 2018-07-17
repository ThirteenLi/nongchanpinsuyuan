package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.AgentDao;
import com.gap.domain.Agent;
import com.gap.domain.Customer;
import com.gap.domain.Farmer;
import com.gap.service.AgentService;
import com.gap.utils.MD5Utils;
import com.gap.utils.PageBean;



public class AgentServiceImpl implements AgentService {
	private AgentDao ad;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = ad.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<Agent> list = ad.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	
	@Override
	public void save(Agent agent) {
		if (agent.getPhoneNumber_dls()==null) {
			Agent existA =  ad.getByUserCode(agent.getPhoneNumber_dls());
			if (existA != null) {
				throw new RuntimeException("用户名已经存在!");
			} 
		}
		//使用MD5对密码进行加密
		//farmer.setPassword_nh(MD5Utils.md5(farmer.getPassword_nh()));
		
		ad.saveOrUpdate(agent);
	}
	
	@Override
	public Agent getById(Long id_dls) {
		return ad.getById(id_dls);
	}
	@Override
	public List<Object[]> getIndustryCount() {
		return ad.getIndustryCount();
	}
	
	


	public void setAd(AgentDao ad) {
		this.ad = ad;
	}

	@Override
	public void saveAgent(Agent agent) {
/*		if (customer.getId_cus()==null) {//新增用户,需要校验用户是否存在
			//1 调用Dao根据注册的登陆名获得用户对象
			Customer existC =  cd.getById(customer.getId_cus());
			if (existC != null) {
				//2 如果获得到user对象,用户名已经存在,抛出异常
				throw new RuntimeException("用户名已经存在!");
			} 
		}
*/		//使用MD5对密码进行加密
		//Agent.setPassword_nh(MD5Utils.md5(farmer.getPassword_nh()));
		//3 调用Dao执行保存
		ad.saveOrUpdate(agent);
		
	}

	@Override
	public void deleteById(Long id_dls) {
		// TODO Auto-generated method stub
		ad.delete(id_dls);
	}

	//代理商登录
	@Override
	public Agent getAgentByPhonePassword(Agent agent) {
		Agent getAgent = ad.getByUserCode(agent.getPhoneNumber_dls());
		if (getAgent==null){
			throw new RuntimeException("您输入的用户名不存在！");
		}
		if (!getAgent.getPassword_dls().equals(agent.getPassword_dls())){
			throw new RuntimeException("您输入的密码错误！");
		}
		return getAgent;
	}

	//激活农户权限
	@Override
	public void modifyOpenAuthorization(Agent agent1) {
		agent1.setCondition_dls("1");
		ad.saveOrUpdate(agent1);
		
	}

	//代理商修改密码
	@Override
	public void modifyFarmerPassword(Agent agent, String newPassword) {
		Agent getagentbyId = ad.getById(agent.getId_dls());
		//输入的原密码与实际密码不相符合，抛异常
		if (!getagentbyId.getPassword_dls().equals(agent.getPassword_dls())){
			throw new RuntimeException("您输入的原密码有误！");
		}
		getagentbyId.setPassword_dls(newPassword);
		ad.saveOrUpdate(getagentbyId);
		
	}

	



}
