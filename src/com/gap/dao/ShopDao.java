package com.gap.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Shop;



public interface ShopDao extends BaseDao<Shop>{
	//查询当前用户的所有农场
	public Shop getShopByName(String string);
	/** 查：根据条件查询对象，分页查询*/
	
	public List<Shop> getShopPageList(DetachedCriteria dc, Integer start, Integer pageSize) ;	

	
}
