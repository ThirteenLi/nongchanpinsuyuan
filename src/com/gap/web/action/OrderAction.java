package com.gap.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gap.domain.Order;
import com.gap.domain.Shop;
import com.gap.service.OrderService;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	
	Order order = new Order();
	OrderService orderService;
	//private Long sellerid;
	private Integer currentPage;
	private Integer pageSize;

	
	//保存订单信息
	public String writeOrder(){
		orderService.saveOrderInfo(order);		
		return "writeOrder";
	}

	//农户查询所有订单信息
	public String searchAllOrder(){
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.eq("sellerid", order.getSellerid()) );
		dc.add(Restrictions.eq("sellerzl", "farmer") );
		dc.add(Restrictions.eq("conditon_order", "0") );
		//3 调用Service查询分页数据(PageBean)
		PageBean pb = orderService.getPageBean(dc, currentPage, pageSize);
		//4 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().getSession().put("orderpageBean", pb);
		return "searchAllOrder";
	}
	
	
	//代理商查询所有订单信息
	public String searchAlldlsOrder(){
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.eq("sellerid", order.getSellerid()) );
		dc.add(Restrictions.eq("sellerzl", "agent") );
		dc.add(Restrictions.eq("conditon_order", "0") );
		//3 调用Service查询分页数据(PageBean)
		PageBean pb = orderService.getPageBean(dc, currentPage, pageSize);
		//4 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().getSession().put("orderdlspageBean", pb);
		return "searchAlldlsOrder";
	}
	
	//农户获取订单
	public String NHGetOneOrder(){
		Order orderById = orderService.getOrderById(order);
		ActionContext.getContext().getSession().put("agentorder", orderById);
		return "NHGetOneOrder";
	}
	
	
	
	//农户获取订单
	public String DLSGetOneOrder(){
		Order orderById = orderService.getOrderById(order);
		ActionContext.getContext().getSession().put("agentorder1", orderById);
		return "DLSGetOneOrder";
	}
	
	@Override
	public Order getModel() {
		return order;
	}
	
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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
	
	
	
}
