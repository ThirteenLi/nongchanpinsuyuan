package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.FarmerDao;
import com.gap.domain.Customer;
import com.gap.domain.Farmer;
import com.gap.service.FarmerService;
import com.gap.utils.FarmerRepository;
import com.gap.utils.MD5Utils;
import com.gap.utils.PageBean;



public class FarmerServiceImpl implements FarmerService {
	private FarmerDao fd;
	
	/** 管理员 获取农户分页信息*/ 
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = fd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		List<Farmer> list = fd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		//5 返回分页信息
		return pb;
	}
	
	
	/** 管理员 保存新农户的方法*/ 
	@Override
	public void save(Farmer farmer) {
		if (farmer.getPhoneNumber_nh()==null) {
			Farmer existF =  fd.getByPhoneNumber(farmer.getPhoneNumber_nh());
			if (existF != null) {
				throw new RuntimeException("用户名已经存在!");
			} 
		}
		//使用MD5对密码进行加密
		//farmer.setPassword_nh(MD5Utils.md5(farmer.getPassword_nh()));
		fd.saveOrUpdate(farmer);
	}
	
	
	/** 管理员 删除农户的方法*/ 
	@Override
	public void deleteById(Long id_nh) {
		fd.delete(id_nh);
	}
	
	/** 农户 注册方法*/ 
	@Override
	public void saveNewFarmer(Farmer farmer) {
		//手机号码存在性测试
		Farmer existFarmerTest = fd.getByPhoneNumber(farmer.getPhoneNumber_nh());
		if (existFarmerTest != null){
			throw new RuntimeException("该手机号已经注册");
		}
		//身份证号码存在性测试
		Farmer existFarmerTest2 = fd.getByIDCardNumber(farmer.getIDCardNum_nh());
		if (existFarmerTest2 != null){
			throw new RuntimeException("您已注册！若信息被盗用，请联系管理员!");
		}
		//将农户的权限标记为审核状态
		farmer.setCondition_nh("0");
		//调用Dao层的方法，保存农户信息
		fd.save(farmer);
	}
	
	/** 农户 登录方法*/ 
	@Override
	public Farmer getFarmerByPhonePassword(Farmer farmer) {
		Farmer getFarmer = fd.getByPhoneNumber(farmer.getPhoneNumber_nh());
		if (getFarmer == null){
			throw new RuntimeException("您输入的用户名不存在！");
		}
		if (!getFarmer.getPassword_nh().equals(farmer.getPassword_nh())){
			throw new RuntimeException("您输入的密码错误！");
		}
		if (getFarmer.getCondition_nh().equals("-1")){
			throw new RuntimeException("您的用户在审核中！");
		}
		return getFarmer;
	}
	
	
	
	//打开权限
	@Override
	public void modifyOpenAuthorization(Farmer farmer1) {
		farmer1.setCondition_nh("1");
		fd.saveOrUpdate(farmer1);
		
	}


	/** 修改农户信息*/
	@Override
	public void modifyFarmerInfo(Farmer farmer) {
		fd.saveOrUpdate(farmer);
		
	}


	//修改密码
	@Override
	public void modifyFarmerPassword(Farmer farmer, String newPassword) {
		Farmer getfarmerbyId = fd.getById(farmer.getId_nh());
		//输入的原密码与实际密码不相符合，抛异常
		if (!getfarmerbyId.getPassword_nh().equals(farmer.getPassword_nh())){
			throw new RuntimeException("您输入的原密码有误！");
		}
		getfarmerbyId.setPassword_nh(newPassword);
		fd.saveOrUpdate(getfarmerbyId);
		
	}
	


	
	
	
	
	
	@Override
	public Farmer getById(Long id_nh) {
		return fd.getById(id_nh);
	}
	@Override
	public List<Object[]> getIndustryCount() {
		return fd.getIndustryCount();
	}
	public void setFd(FarmerDao fd) {
		this.fd = fd;
	}




	
	
	








	



}
