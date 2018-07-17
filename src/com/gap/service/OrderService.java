package com.gap.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.domain.Order;
import com.gap.utils.PageBean;

public interface OrderService {
	
	//保存订单
	public void saveOrderInfo(Order order);
	
	//查询所有订单
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//根据id号查订单
	public Order getOrderById(Order order);

}
