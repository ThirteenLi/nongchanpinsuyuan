package com.gap.web.action;



import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.gap.domain.Agent;
import com.gap.domain.Farmer;
import com.gap.domain.Shop;
import com.gap.service.ShopService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ShopAction extends ActionSupport implements ModelDriven<Shop>{

	/** 调用Service层shopServiceervice类的对象shopService*/
	private ShopService shopService;
	
	
	/** 从前端接收的参数*/
	Shop shop = new Shop();
	@Override
	public Shop getModel() {
		return shop;
	}
	private Integer currentPage;
	private Integer pageSize;
	private Long id_dls;	
	private Integer page;
	private Integer rows;
	

	/** 代理商用给前端调用的list方法，用来显示所有代理点信息*/
	public String list() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
		//2 判断并封装参数
		if (shop.getId_dls() != null){
			dc.add(Restrictions.eq("agent.id_dls", shop.getId_dls()) );
			dc.add(Restrictions.eq("condition_shop", "1") );	
		}	
		//3 调用Service查询分页数据(PageBean)
		PageBean pb = shopService.getDLSPageBean(dc, currentPage, pageSize);
		//4 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().getSession().put("shoppageBean", pb);
		//5 往struts中传递“list”标记
		return "list";	
	}
	
	
	
	
	/** 添加农产品，其实没多大用处的方法*/
	public String list2() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
		//2 判断并封装参数
		if (shop.getId_dls() != null){
			dc.add(Restrictions.eq("farmer.id_dls", shop.getId_dls()) );
			dc.add(Restrictions.eq("condition_shop", "1") );	
		}	
		//3 调用Service查询分页数据(PageBean)
		PageBean pb = shopService.getDLSPageBean(dc, currentPage, pageSize);
		//4 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().getSession().put("farmpageBean", pb);
		//5 往struts中传递“list”标记
		return "jumpToAdd";	
	}

	
	
	/** 管理员 添加代理商*/
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			Agent agenttemp = new Agent();
			agenttemp.setId_dls(shop.getId_dls());
			shop.setAgent(agenttemp);
			shopService.save(shop);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return null;
	}
	
	
	/** 给前端调用的list方法，用来显示所有代理点信息*/
	public String listAdmin() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
		PageBean pb = shopService.getPageBean(dc, page,rows);
		Map map = new HashMap<>();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		//4 将map转换为json
		String json = JSON.toJSONString(map);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		//5 不需要struts处理
		return null;	
	}
	
	/** 给前端调用的list方法，用来显示所有代理点信息*/
	public String listAdminCheck() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
		dc.add(Restrictions.eq("condition_shop", "0"));
		PageBean pb = shopService.getPageBean(dc, page,rows);
		Map map = new HashMap<>();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		//4 将map转换为json
		String json = JSON.toJSONString(map);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		//5 不需要struts处理
		return null;	
	}
	
	//申请一个新代理点
	public String applyNewShop() throws Exception{		
		try{
			shopService.saveNewShop(shop);
			return "list";
		}catch (Exception e) {
			e.printStackTrace();
			return "applyerror";
		}
	}
	
	
	
	/** 管理员 修改代理商信息,先获取*/
	public String toEdit() throws Exception {
		Shop Shop1 = shopService.getById(shop.getId_shop());
		String json = JSON.toJSONString(Shop1);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	
	
	/** 管理员 删除代理点信息*/
	public String delete() throws Exception {
		shopService.deleteById(shop.getId_shop());
		return null;
	}
	
	

	
	
	//============Get/Set方法===========================================







	public Integer getCurrentPage() {
		return currentPage;
	}




	public ShopService getShopService() {
		return shopService;
	}




	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
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




	public Long getId_dls() {
		return id_dls;
	}




	public void setId_dls(Long id_dls) {
		this.id_dls = id_dls;
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
