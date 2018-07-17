package com.gap.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.NongchangDao;
import com.gap.domain.Nongchang;
import com.gap.service.NongchangService;
import com.gap.utils.PageBean;

public class NongchangServiceImpl implements NongchangService {

	private NongchangDao ncd;

	public void setNcd(NongchangDao ncd) {
		this.ncd = ncd;
	}


	
	/** 分页查询农场信息*/
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = ncd.getTotalCount(dc);		
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);		
		//3 调用Dao查询分页列表数据
		List<Nongchang> list = ncd.getNongchangPageList(dc, pb.getStart(), pb.getPageSize());		
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);		
		//5 将PageBean信息返回
		return pb;
	}
	

	
	
	/** 分页查询农场信息*/
	@Override
	public PageBean getNCPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = ncd.getTotalCount(dc);		
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);		
		//3 调用Dao查询分页列表数据
		//List<Nongchang> list = ncd.getNongchangPageList(dc, pb.getStart(), pb.getPageSize());		
		List<Nongchang> list = ncd.getPageList(dc, pb.getStart(), pb.getPageSize());
		
		
		
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);		
		//5 将PageBean信息返回
		return pb;
	}

	//保存新申请的农户
	@Override
	public void saveNewFarm(Nongchang nongchang) {
		Nongchang existOrNot = ncd.getNongchangByName(nongchang.getName_ncfarm());
		if (existOrNot != null){
			throw new RuntimeException("该农场名已经注册");
		}else{
			ncd.save(nongchang);
		}
	}



	//根据id查农户
	@Override
	public Nongchang getById(Long id_ncfarm) {
		Nongchang byId = ncd.getById(id_ncfarm);
		byId.setId_nh(byId.getFarmer().getId_nh());
		return byId;
	}


	//管理员添加一个新的农场
	@Override
	public void save(Nongchang nongchang) {
		ncd.saveOrUpdate(nongchang);
		
	}


	//管理员根据id删除农场
	@Override
	public void deleteById(Long id_ncfarm) {
		ncd.delete(id_ncfarm);
	}
	
}
