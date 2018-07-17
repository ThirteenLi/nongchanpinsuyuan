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
import com.gap.domain.Customer;
import com.gap.service.CustomerService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;




public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	private Customer customer = new Customer();
	private CustomerService cs;
	private Integer page;
	private Integer rows;
	
	ActionContext ctx = ActionContext.getContext();                
	HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);          
	HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
	
	//查询数据库中全部消费者的信息
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = cs.getPageBean(dc,page,rows);
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
			cs.save(customer);
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
		Customer cus = cs.getById(customer.getId_cus());
		cus.setPassword_cus("");
		String json = JSON.toJSONString(cus);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;
	}

	
	//删除消费者信息
	public String delete() throws Exception {
		cs.deleteById(customer.getId_cus());
		return null;
	}
	
	public String industryCount() throws Exception {			
		List<Object[]> list = cs.getIndustryCount();	
		ActionContext.getContext().put("list", list);		
		return "industryCount";	
	}

	//激活消费者账号
	public String openAuthorization() throws Exception{
		//查出要激活的用户
		Customer cus = cs.getById(customer.getId_cus());
		cs.modifyOpenAuthorization(cus);
		return null;
	}
	
	//主页的注册消费者账号
	public String registNewCustomer() throws Exception {
		//1 调用Service保存注册用户
		try {
			cs.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return "sccessRegist";
	}
	 
	
	//消费者登录
	public String loginCustomer() throws Exception{
		try{
			Customer customer1 = cs.getCustomerByPhonePassword(customer);
			ActionContext.getContext().getSession().put("customer1", customer1);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}
		
		return "toLogin";
	}
	
	public void checkPhoneNumber(){
		String phoneNumber_cus1 = customer.getPhoneNumber_cus();
		boolean isExist = cs.getCustomerByPhone(phoneNumber_cus1);
		
		try {
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------------
	@Override
	public Customer getModel() {
		return customer;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
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
