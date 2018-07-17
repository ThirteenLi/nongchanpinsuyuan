package com.gap.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.OrderDao;
import com.gap.domain.Order;
import com.gap.service.OrderService;
import com.gap.utils.PageBean;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
	public void saveOrderInfo(Order order){
		order.setConditon_order("0");
		orderDao.saveOrUpdate(order);
	}
	
	
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = orderDao.getTotalCount(dc);		
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);		
		//3 调用Dao查询分页列表数据
		List<Order> list = orderDao.getPageList(dc, pb.getStart(), pb.getPageSize());		
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);		
		//5 将PageBean信息返回
		return pb;
	}
	
	//根据id查订单
	@Override
	public Order getOrderById(Order order) {
		return orderDao.getById(order.getId_order());
	}
	
	
	
}
