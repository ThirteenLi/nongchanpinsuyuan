package com.gap.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gap.domain.Apply;
import com.gap.domain.Checker;
import com.gap.domain.Customer;
import com.gap.domain.Farmer;
import com.gap.domain.Nongchang;
import com.gap.domain.Order;
import com.gap.domain.Product;
import com.gap.domain.Shop;
import com.gap.service.ApplyService;
import com.gap.service.CheckerService;
import com.gap.service.CustomerService;
import com.gap.service.FarmerService;
import com.gap.service.NongchangService;
import com.gap.service.OrderService;
import com.gap.service.ProductService;
import com.gap.service.ShopService;
import com.gap.utils.FarmerRepository;
import com.gap.utils.Origin;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {
	@Resource(name="customerService")
	CustomerService cs;
	
	@Resource(name="farmerService")
	FarmerService fs;
	
	@Resource(name="checkerService")
	CheckerService checkers;

	@Resource(name="nongchangService")
	NongchangService ncs;

	@Resource(name="productService")
	ProductService ProductService;

	
	@Resource(name="applyService")
	ApplyService applyService;
	
	@Resource(name="shopService")
	ShopService shopService;
	
	@Resource(name="orderService")
	OrderService orderService;	
	
	@Test
	public void test8(){
		
		Product p = new Product();
		p.setIdHead_rep("20180409_205305_10");
		p.setIdOwner_rep(3l);
		p.setIdPlace_rep(3l);
		p.setNumber_rep("30");
		
	/*	ProductService.saveDLSProduct(p, 2l);*/
		
		
	}	
	
	
	@Test
	public void test7(){
		Apply farmerApply = new Apply();
		farmerApply.setUsercategory("farmer");
		farmerApply.setUserid("10");
		farmerApply.setZt("已审核");
		farmerApply.setUserapply("好不好使好不好使");
		applyService.saveNHChangeFarmApply(farmerApply );
	}
	
	@Test
	public void myTest6(){
		//1 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Nongchang.class);
		//2 判断并封装参数
		
		dc.add(Restrictions.eq("farmer.id_nh", 10l) );
		dc.add(Restrictions.eq("condition_ncfarm", "1"));
		
		//3 调用Service查询分页数据(PageBean)
		
		PageBean pb = ncs.getNCPageBean(dc, 1, 10);
		System.out.println(pb.getList());
	}
	
	@Test
	public void myTest5(){
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Farmer.class);

		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = fs.getPageBean(dc,1,10);
		//2 将列表数据转换为json发送给浏览器
		Map map = new HashMap<>();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		//将map转换为json
		String json = JSON.toJSONString(map);
		System.out.println(json);

	}
	
	@Test
	public void myTest1(){
		Customer customer1 = new Customer();
		customer1.setNickName_cus("项目姓名测试数据10");
		cs.save(customer1);
	}
	
	@Test
	public void myTest2(){
		Farmer f =  new Farmer();
		f.setPassword_nh("123");
		f.setRealName_nh("农户用户名测试");
		fs.save(f);
	}
	
	@Test
	public void myTest3(){
		boolean ttt = cs.getCustomerByPhone("wwwwwwwwwwwwwwww");
		System.out.println(ttt);
	}
	
	@Test
	public void myTest4(){
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Checker.class);
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = checkers.getPageBean(dc,1,10);
		//2 将列表数据转换为json发送给浏览器
		Map map = new HashMap<>();
		map.put("total", pb.getTotalCount());
		map.put("rows", pb.getList());
		//将map转换为json
		String json = JSON.toJSONString(map);
		System.out.println(json);
	}
	
	


}
