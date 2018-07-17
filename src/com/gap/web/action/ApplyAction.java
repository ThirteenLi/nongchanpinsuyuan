package com.gap.web.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.gap.domain.Agent;
import com.gap.domain.Apply;
import com.gap.domain.Customer;
import com.gap.service.ApplyService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ApplyAction extends ActionSupport implements ModelDriven<Apply> {

	//该myapply接受从前端传过来的信息，由getModel负责装配
	Apply myapply = new Apply();
	//接收分页信息的参数
	private Integer currentPage;
	private Integer pageSize;
	//service层的对象
	ApplyService applyService;
	
	private Integer page;
	private Integer rows;
	
	//管理员查询数据库中全部消费者的信息
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = applyService.getPageBean(dc,page,rows);
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
	
	//管理员删除
	public String delete() throws Exception {
		applyService.deleteById(myapply.getId_message());
		return null;
	}
	
	//编辑
	public String toEdit() throws Exception {
		Apply apply = applyService.getById(myapply.getId_message());		
		String json = JSON.toJSONString(apply);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;
	}
	
	
	/** 管理员 添加*/
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		applyService.save(myapply);


		return null;
	}
	
	//【农场】农户对农场变更申请的方法
	public String NhFarmChangeApply(){
		applyService.saveNHChangeFarmApply(myapply);
		return "nhapplysuccess";
	}
	
	
	//【代理点】代理商对代理点变更申请的方法
	public String DLSShopChangeApply(){
		applyService.saveDLSChangeShopApply(myapply);
		return "dlsapplysuccess";
	}
	
	//【农场】农户查询农场变更进度
	public String SearchApplySchedule(){
		DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
		dc.add(Restrictions.eq("userid", myapply.getUserid()));
		dc.add(Restrictions.eq("usercategory", "farmer"));
		dc.add(Restrictions.or(Restrictions.eq("applycategory", "农场注销申请"), Restrictions.eq("applycategory", "农场信息修改")));
		PageBean pb = applyService.getApplyPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("schedulePB", pb);
		return "nhToScheduleList";
	}
	
	
	//【代理点】代理商查询代理点变更进度
	public String SearchdlsApplySchedule(){
		DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
		dc.add(Restrictions.eq("userid", myapply.getUserid()));
		dc.add(Restrictions.eq("usercategory", "agent"));
		dc.add(Restrictions.or(Restrictions.eq("applycategory", "代理点注销申请"), Restrictions.eq("applycategory", "代理点信息修改")));
		PageBean pb = applyService.getApplyPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("dlsschedulePB", pb);
		return "dlsToScheduleList";
	}
	
	//农户联系管理员
	public String FarmerContectAdmin(){
		//调用service层的方法保存从前端传过来的对象myapply
		applyService.saveFarmerApply(myapply);
		//返回farmerContectAdmin，让struts接收
		return "farmerContectAdmin";
	}
	
	
	//代理商联系管理员
	public String AgentContectAdmin(){
		//调用service层的方法保存从前端传过来的对象myapply
		applyService.saveAgentApply(myapply);
		//返回farmerContectAdmin，让struts接收
		return "agentrContectAdmin";
	}
	
	//农户查询申请进度
	public String FarmerApplyChange(){
		DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
		dc.add(Restrictions.eq("userid", myapply.getUserid()));
		dc.add(Restrictions.eq("usercategory", "farmer"));
		dc.add(Restrictions.or(Restrictions.eq("applycategory", "农户信息变更"), Restrictions.eq("applycategory", "农户留言")));
		PageBean pb = applyService.getApplyPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("FarmerInfoPB", pb);
		return "farmerApplyChange";
	}
	
	
	//代理商查询申请进度
	public String AgentApplyChange(){
		DetachedCriteria dc = DetachedCriteria.forClass(Apply.class);
		dc.add(Restrictions.eq("userid", myapply.getUserid()));
		dc.add(Restrictions.eq("usercategory", "agent"));
		dc.add(Restrictions.or(Restrictions.eq("applycategory", "代理商信息变更"), Restrictions.eq("applycategory", "代理商留言")));
		PageBean pb = applyService.getApplyPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("FarmerInfoPB", pb);
		return "agentApplyChange";
	}
	
	
	//模型驱动方法
	@Override
	public Apply getModel() {
		return myapply;
	}

	//applyService的get/set方法，由spring进行装配
	public ApplyService getApplyService() {
		return applyService;
	}
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}


	//分页的getset方法
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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



	
	
}
