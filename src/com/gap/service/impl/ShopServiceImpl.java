package com.gap.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.ShopDao;
import com.gap.domain.Shop;
import com.gap.service.ShopService;
import com.gap.utils.PageBean;

public class ShopServiceImpl implements ShopService {

	private ShopDao shopDao;
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}




	/** 分页查询代理点信息*/
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = shopDao.getTotalCount(dc);		
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);		
		//3 调用Dao查询分页列表数据
		List<Shop> list = shopDao.getShopPageList(dc, pb.getStart(), pb.getPageSize());		
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);		
		//5 将PageBean信息返回
		return pb;
	}
	

	
	
	/** 分页查询代理点信息*/
	@Override
	public PageBean getDLSPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = shopDao.getTotalCount(dc);		
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);		
		//3 调用Dao查询分页列表数据				
		List<Shop> list = shopDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);		
		//5 将PageBean信息返回
		return pb;
	}

	//保存新申请的代理商
	@Override
	public void saveNewShop(Shop shop) {
		Shop existOrNot = shopDao.getShopByName(shop.getName_shop());
		if (existOrNot != null){
			throw new RuntimeException("该代理点名已经注册");
		}else{
			shopDao.save(shop);
		}
	}



	//根据id查代理商
	@Override
	public Shop getById(Long id_shop) {
		Shop byId = shopDao.getById(id_shop);		
		return byId;
	}


	//管理员添加一个新的代理点
	@Override
	public void save(Shop shop) {
		shopDao.saveOrUpdate(shop);
		
	}


	//管理员根据id删除代理点
	@Override
	public void deleteById(Long id_shop) {
		shopDao.delete(id_shop);
	}
	
}
