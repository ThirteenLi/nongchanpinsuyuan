package com.gap.service;


import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Shop;
import com.gap.utils.PageBean;

public interface ShopService {
	

	//根据条件查询，返回分页对象PageBean
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//农户专用方法
	public PageBean getDLSPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//申请农场
	public void saveNewShop(Shop shop);

	//根据id查询农场
	public Shop getById(Long id_shop);

	public void save(Shop shop);

	//管理员根据id删除农场
	public void deleteById(Long id_shop);
}
