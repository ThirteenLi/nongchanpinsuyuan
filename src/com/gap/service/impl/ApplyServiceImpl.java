package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.ApplyDao;
import com.gap.domain.Apply;
import com.gap.domain.Customer;
import com.gap.service.ApplyService;
import com.gap.utils.PageBean;

public class ApplyServiceImpl implements ApplyService {

	private ApplyDao applyDao;
	
	//农户变更农场申请
	@Override
	public void saveNHChangeFarmApply(Apply farmerApply) {
		//设置修改类型为农户
		farmerApply.setUsercategory("farmer");
		//调用dao层的方法保存
		applyDao.saveOrUpdate(farmerApply);
	}
	
	
	
	//代理商变更代理点申请
	@Override
	public void saveDLSChangeShopApply(Apply agentapply) {
		//设置修改类型为农户
		agentapply.setUsercategory("agent");
		//调用dao层的方法保存
		applyDao.saveOrUpdate(agentapply);
		
	}
	
	//农户获取农场变更申请进度列表
	@Override
	public PageBean getApplyPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1、调用dao查询总记录数
		Integer totalCount = applyDao.getTotalCount(dc);
		//2、创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3、调用dao查询分页列表信息
		List<Apply> pageList = applyDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		//4、将pageList放入list中
		pb.setList(pageList);
		//5、返回
		return pb;
	}
	
	
	//农户的申请和留言
	@Override
	public void saveFarmerApply(Apply farmerApply) {
		//设置修改类型为农户
		farmerApply.setUsercategory("farmer");
		//调用dao层的方法提交请求
		applyDao.saveOrUpdate(farmerApply);
		
	}
	
	//代理商的申请和留言
	@Override
	public void saveAgentApply(Apply agentApply) {
		//设置修改类型为代理商
		agentApply.setUsercategory("agent");
		//调用dao层的方法提交请求
		applyDao.saveOrUpdate(agentApply);
		
	}
	
	
	//==============Get/Set方法======================
	public ApplyDao getApplyDao() {
		return applyDao;
	}
	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}



	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer page, Integer rows) {
		//1 调用Dao查询总记录数
		Integer totalCount = applyDao.getTotalCount(dc);  
		//2 创建PageBean对象
		PageBean pb = new PageBean(page, totalCount, rows);  
		//3 调用Dao查询分页列表数据
		List<Apply> list = applyDao.getPageList(dc,pb.getStart(),pb.getPageSize());  
		//4 列表数据放入pageBean中
		pb.setList(list);
		//5 结果返回
		return pb;
	}


	//管理员
	@Override
	public void deleteById(Long id_message) {
		applyDao.delete(id_message);
		
	}



	@Override
	public Apply getById(Long id_message) {
		
		return applyDao.getById(id_message);
	}



	@Override
	public void save(Apply myapply) {
		applyDao.saveOrUpdate(myapply);
	}












	
	
}