package com.gap.web.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


import com.alibaba.fastjson.JSON;
import com.gap.domain.Checker;
import com.gap.service.CheckerService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;




public class CheckerAction extends ActionSupport implements ModelDriven<Checker> {
	
	private Checker checker = new Checker();
	private CheckerService checkers;
	private Integer page;
	private Integer rows;
	
	ActionContext ctx = ActionContext.getContext();                
	HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);          
	HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
	
	//查询数据库中全部消费者的信息
	
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Checker.class);
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = checkers.getPageBean(dc,page,rows);
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
	

	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			checkers.save(checker);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return null;
	}

	//修改消费者信息
	public String toEdit() throws Exception {
		Checker checker1 = checkers.getById(checker.getId_zjy());
		checker.setPassword_zjy("");
		String json = JSON.toJSONString(checker1);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;
	}

	
	//删除消费者信息
	public String delete() throws Exception {
		checkers.deleteById(checker.getId_zjy());
		return null;
	}
	
	public String industryCount() throws Exception {			
		List<Object[]> list = checkers.getIndustryCount();	
		ActionContext.getContext().put("list", list);		
		return "industryCount";	
	}

	//激活消费者账号
	public String openAuthorization() throws Exception{
		//查出要激活的用户
		Checker checker1 = checkers.getById(checker.getId_zjy());
		checkers.modifyOpenAuthorization(checker1);
		return null;
	}
	
	//主页的注册消费者账号
	public String registNewChecker() throws Exception {
		//1 调用Service保存注册用户
		try {
			checkers.save(checker);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return "sccessRegist";
	}
	 
	
	//消费者登录
	public String loginChecker() throws Exception{
		try{
			Checker checker1 = checkers.getCheckerByUserNamePassword(checker);
			ActionContext.getContext().getSession().put("checker1", checker1);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}
		
		return "checkLogin";
	}

	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------------
	@Override
	public Checker getModel() {
		return checker;
	}

	public void setCheckers(CheckerService checkers) {
		this.checkers = checkers;
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
