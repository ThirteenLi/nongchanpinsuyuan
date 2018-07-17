package com.gap.web.action;



import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.gap.domain.Farmer;
import com.gap.domain.Nongchang;
import com.gap.service.NongchangService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NongchangAction extends ActionSupport implements ModelDriven<Nongchang>{

	/** 调用Service层NongchangService类的对象nongchangs*/
	private NongchangService nongchangs;
	
	
	/** 从前端接收的参数*/
	Nongchang nongchang = new Nongchang();
	private Integer currentPage;
	private Integer pageSize;
	private Long id_nh;	
	private Integer page;
	private Integer rows;
	

	/** 农户用给前端调用的list方法，用来显示所有农场信息*/
	public String list() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Nongchang.class);
		//2 判断并封装参数
		if (nongchang.getId_nh() != null){
			dc.add(Restrictions.eq("farmer.id_nh", nongchang.getId_nh()) );
			dc.add(Restrictions.eq("condition_ncfarm", "1") );	
		}	
		//3 调用Service查询分页数据(PageBean)
		PageBean pb = nongchangs.getNCPageBean(dc, currentPage, pageSize);
		//4 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().getSession().put("farmpageBean", pb);
		//5 往struts中传递“list”标记
		return "list";	
	}
	
	
	
	
	/** 添加农产品，其实没多大用处的方法*/
	public String list2() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Nongchang.class);
		//2 判断并封装参数
		if (nongchang.getId_nh() != null){
			dc.add(Restrictions.eq("farmer.id_nh", nongchang.getId_nh()) );
			dc.add(Restrictions.eq("condition_ncfarm", "1") );	
		}	
		//3 调用Service查询分页数据(PageBean)
		PageBean pb = nongchangs.getNCPageBean(dc, currentPage, pageSize);
		//4 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().getSession().put("farmpageBean", pb);
		//5 往struts中传递“list”标记
		return "jumpToAdd";	
	}

	/** 管理员 添加农场*/
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			Farmer farmertemp = new Farmer();
			farmertemp.setId_nh(nongchang.getId_nh());
			nongchang.setFarmer(farmertemp);
			nongchangs.save(nongchang);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return null;
	}
	
	
	/** 给前端调用的list方法，用来显示所有农场信息*/
	public String listAdmin() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Nongchang.class);
		PageBean pb = nongchangs.getPageBean(dc, page,rows);
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
	
	/** 给前端调用的list方法，用来显示所有农场信息*/
	public String listAdminCheck() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Nongchang.class);
		dc.add(Restrictions.eq("condition_ncfarm", "0"));
		PageBean pb = nongchangs.getPageBean(dc, page,rows);
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
	
	//申请一个新农场
	public String applyNewFarm() throws Exception{		
		try{
/*			Farmer ftemp = new Farmer();
			ftemp.setId_nh(id_nh);
			nongchang.setFarmer(ftemp);*/
			nongchangs.saveNewFarm(nongchang);
			return "list";
		}catch (Exception e) {
			e.printStackTrace();
			return "applyerror";
		}
	}
	
	
	
	/** 管理员 修改农户信息,先获取*/
	public String toEdit() throws Exception {
		Nongchang nongchang1 = nongchangs.getById(nongchang.getId_ncfarm());
		String json = JSON.toJSONString(nongchang1);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	
	
	/** 管理员 删除农场信息*/
	public String delete() throws Exception {
		nongchangs.deleteById(nongchang.getId_ncfarm());
		return null;
	}
	
	//============Get/Set方法===========================================
	public NongchangService getNongchangs() {
		return nongchangs;
	}
	public void setNongchangs(NongchangService nongchangs) {
		this.nongchangs = nongchangs;
	}
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
	@Override
	public Nongchang getModel() {
		return nongchang;
	}


	public Long getId_nh() {
		return id_nh;
	}


	public void setId_nh(Long id_nh) {
		this.id_nh = id_nh;
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
