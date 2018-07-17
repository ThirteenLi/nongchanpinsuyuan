package com.gap.web.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.alibaba.fastjson.JSON;
import com.gap.domain.Customer;
import com.gap.domain.Quality;
import com.gap.service.QualityService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QualityAction extends ActionSupport implements ModelDriven<Quality> {

	Quality quality = new Quality();
	private Integer page;
	private Integer rows;
	QualityService qualityService;
	@Override
	public Quality getModel() {
		return quality;
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
	
	public QualityService getQualityService() {
		return qualityService;
	}
	public void setQualityService(QualityService qualityService) {
		this.qualityService = qualityService;
	}
	//查询数据库中全部消费者的信息
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Quality.class);
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = qualityService.getPageBean(dc,page,rows);
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
			qualityService.save(quality);

		//2 重定向到登陆页面
		return null;
	}
	
	
	//删除消费者信息
	public String delete() throws Exception {
		qualityService.deleteById(quality.getId_zl());
		return null;
	}
	
	
	//修改消费者信息
	public String toEdit() throws Exception {
		Quality q  = qualityService.getById(quality.getId_zl());
		
		String json = JSON.toJSONString(q);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;
	}
	
	
	public String searchQuality() throws Exception{
		try{
			Quality byCode = qualityService.getByCode(quality.getId_pro());
			ActionContext.getContext().getSession().put("byCode", byCode);
			return "searchQuality";
			
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
		
			return "error";
		}
		
		
	}
}
