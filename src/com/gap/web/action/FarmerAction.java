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
import com.gap.domain.Customer;
import com.gap.domain.Farmer;
import com.gap.service.CustomerService;
import com.gap.service.FarmerService;
import com.gap.utils.GenerateNumberUtils;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;




public class FarmerAction extends ActionSupport implements ModelDriven<Farmer> {
	

	private Farmer farmer = new Farmer();
	private FarmerService fs;
	
	private Integer page;
	private Integer rows;
	private Integer currentPage;
	private Integer pageSize;
	private String newPassword;
	
	
	/** 管理员 显示全部农户的方法*/
	public String list() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Farmer.class);
		//2 调用Service查询分页数据(PageBean)
		PageBean pb = fs.getPageBean(dc,page,rows);
		//3 将列表数据转换为json发送给浏览器
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
	
	
	/** 管理员 显示全部农户的方法*/
	public String listCheck() throws Exception {
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Farmer.class);
		dc.add(Restrictions.eq("condition_nh", "-1"));
		PageBean pb = fs.getPageBean(dc,page,rows);
		//3 将列表数据转换为json发送给浏览器
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
	
	/** 管理员 添加农户*/
	public String regist() throws Exception {
		//1 调用Service保存注册用户
		try {
			fs.save(farmer);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//2 重定向到登陆页面
		return null;
	}

	
	/** 管理员 修改农户信息,先获取*/
	public String toEdit() throws Exception {
		Farmer fa = fs.getById(farmer.getId_nh());
		String json = JSON.toJSONString(fa);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	
	/** 管理员 删除农户信息*/
	public String delete() throws Exception {
		fs.deleteById(farmer.getId_nh());
		return null;
	}
	
	/** 管理员 激活账号*/
	public String openAuthorization() throws Exception{
		//查出要激活的用户
		Farmer farmer1 = fs.getById(farmer.getId_nh());
		fs.modifyOpenAuthorization(farmer1);
		return null;
	}
	
	
	/** 农户 注册成为农户*/
	public String registNewFarmer() throws Exception{
		try {
			/*fs.save(farmer);*/
			fs.saveNewFarmer(farmer);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("farmerRegisterror", e.getMessage());
			return "FarmerRegisterror";
		}
		return "sccessRegist";
	}
	
	
	/** 农户 农户登录*/
	public String loginFarmer() throws Exception{
		try{
			Farmer farmer1 = fs.getFarmerByPhonePassword(farmer);
			//0代表有已经注册，但是未上传实名制。
			if (farmer1.getCondition_nh().equals("0")){
				ActionContext.getContext().getSession().put("farmer2", farmer1);
				return "toRealName";
			}
			ActionContext.getContext().getSession().put("farmer1", farmer1);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}	
		return "toLogin";
	}
	
	
	/** 农户 提交实名制验证*/
	public String upload() throws Exception{
		Farmer fa_temp = fs.getById(farmer.getId_nh());
		
		String realPath = "C:/pic/"+ GenerateNumberUtils.generatePictureName(fa_temp.getPhoneNumber_nh(), "pictureIDCF_nh") + ".jpg";
		String realPath2 = "C:/pic/"+ GenerateNumberUtils.generatePictureName(fa_temp.getPhoneNumber_nh(), "pictureIDCB_nh") + ".jpg";
		String realPath3 = "C:/pic/"+ GenerateNumberUtils.generatePictureName(fa_temp.getPhoneNumber_nh(), "pictureIDC_nh") + ".jpg";
		photo.renameTo(new File(realPath));
		photo2.renameTo(new File(realPath2));
		photo3.renameTo(new File(realPath3));
		
		
		fa_temp.setPictureIDCF_nh(realPath);
		fa_temp.setPictureIDCB_nh(realPath2);
		fa_temp.setPictureIDC_nh(realPath3);
		fa_temp.setCondition_nh("-1");
		fs.modifyFarmerInfo(fa_temp);
		return "sccessSubmitId";
	}
	
	
	//农户修改密码
	public String changeFarmerPassword() throws Exception{	
		try{		
			fs.modifyFarmerPassword(farmer, newPassword);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("FarmerChangePassworderror", e.getMessage());
			return "FarmerChangePassworderror";
		}
		
		return "changeFarmerPassword";
	}
	
	
	

	
	public String industryCount() throws Exception {			
		List<Object[]> list = fs.getIndustryCount();	
		ActionContext.getContext().put("list", list);		
		return "industryCount";	
	}
	
	@Override
	public Farmer getModel() {
		return farmer;
	}

	public void setFs(FarmerService fs) {
		this.fs = fs;
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

	private File photo;
	private File photo2;
	private File photo3;
	private String photoFileName;
	private String photo2FileName;
	private String photo3FileName;
	private String photoContentType;
	
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	
	public File getPhoto2() {
		return photo2;
	}
	public void setPhoto2(File photo2) {
		this.photo2 = photo2;
	}
	public File getPhoto3() {
		return photo3;
	}
	public void setPhoto3(File photo3) {
		this.photo3 = photo3;
	}
	public String getPhoto2FileName() {
		return photo2FileName;
	}
	public void setPhoto2FileName(String photo2FileName) {
		this.photo2FileName = photo2FileName;
	}
	public String getPhoto3FileName() {
		return photo3FileName;
	}
	public void setPhoto3FileName(String photo3FileName) {
		this.photo3FileName = photo3FileName;
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


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	
	
}
