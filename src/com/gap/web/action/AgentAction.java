package com.gap.web.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.alibaba.fastjson.JSON;
import com.gap.domain.Agent;
import com.gap.domain.Farmer;
import com.gap.service.AgentService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;




public class AgentAction extends ActionSupport implements ModelDriven<Agent> {
	

	private Agent agent = new Agent();
	private AgentService as;
	
	private Integer page;
	private Integer rows;
	private String newPassword;
	
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Agent.class);
		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = as.getPageBean(dc,page,rows);
		//2 将列表数据转换为json发送给浏览器
		Map map = new HashMap<>();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		//将map转换为json
		String json = JSON.toJSONString(map);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);	
		return null;
	}
	

	public String listCheck() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Agent.class);
		dc.add(Restrictions.eq("condition_dls", "-1"));
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = as.getPageBean(dc,page,rows);
		//2 将列表数据转换为json发送给浏览器
		Map map = new HashMap<>();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		//将map转换为json
		String json = JSON.toJSONString(map);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);	
		return null;
	}
	
	
	//该方法由系统管理员调用
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			as.save(agent);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return null;
	}

	public String toEdit() throws Exception {
		Agent ag = as.getById(agent.getId_dls());
		ag.setPassword_dls("");
		String json = JSON.toJSONString(ag);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;
	}

	public String delete() throws Exception {
		as.deleteById(agent.getId_dls());

		return null;
	}
	
	public String industryCount() throws Exception {			
		List<Object[]> list = as.getIndustryCount();	
		ActionContext.getContext().put("list", list);		
		return "industryCount";	
	}

	//消费者注册
	public String registNewAgent() throws Exception{
		try {

			as.save(agent);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "sccessRegist";
	}

	
	//消费者登录
	public String loginAgent() throws Exception{
		try{
			Agent agentUser = as.getAgentByPhonePassword(agent);
			ActionContext.getContext().getSession().put("agent1", agentUser);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}
		
		return "toLogin";
	}
	
	
	//激活账号
	public String openAuthorization() throws Exception{
		//查出要激活的用户
		Agent agent1 = as.getById(agent.getId_dls());
		as.modifyOpenAuthorization(agent1);
		return null;
	}
	
	
	
	
	//农户修改密码
	public String changeAgentPassword() throws Exception{	
		try{		
			as.modifyFarmerPassword(agent, newPassword);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("AgentChangePassworderror", e.getMessage());
			return "AgentChangePassworderror";
		}
		
		return "changeAgentPassword";
	}
	
	
	
	@Override
	public Agent getModel() {
		return agent;
	}

	public void setAs(AgentService as) {
		this.as = as;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
