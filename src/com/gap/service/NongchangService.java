package com.gap.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Nongchang;
import com.gap.utils.PageBean;

public interface NongchangService {
	

	//根据条件查询，返回分页对象PageBean
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//农户专用方法
	public PageBean getNCPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//申请农场
	public void saveNewFarm(Nongchang nongchang);

	//根据id查询农场
	public Nongchang getById(Long id_ncfarm);

	public void save(Nongchang nongchang);

	//管理员根据id删除农场
	public void deleteById(Long id_ncfarm);
}
