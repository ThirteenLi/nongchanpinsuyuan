package com.gap.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.gap.dao.FarmerDao;
import com.gap.dao.NongchangDao;
import com.gap.dao.OrderDao;
import com.gap.dao.ProductDao;
import com.gap.dao.ShopDao;
import com.gap.domain.Farmer;
import com.gap.domain.Nongchang;
import com.gap.domain.Order;
import com.gap.domain.Product;
import com.gap.domain.Shop;
import com.gap.service.ProductService;
import com.gap.utils.ChangeDataUtils;
import com.gap.utils.FarmerRepository;
import com.gap.utils.GenerateNumberUtils;
import com.gap.utils.Origin;
import com.gap.utils.PageBean;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao;
	NongchangDao nongchangDao;
	ShopDao shopDao;
	OrderDao orderDao;
	
	/**
	 * 【核心】溯源类的实现
	 * */
	//获得溯源信息
	@Override
	public List<Origin> getOriginInfromationList(String productId) {
		//从数据库中，根据批次号查询信息
		Product productInfo = productDao.getByProductId(productId);
		if (productInfo == null){
			throw new RuntimeException("您输入的溯源码有误！");
		}
		double synum = Double.parseDouble(productInfo.getReduceNum_rep());
		if (synum < 0 || synum==0) {
			throw new RuntimeException("该批次已经售完");
		}
		//创建一个list，用来返回
		List<Origin> originList = new ArrayList<Origin>();
		//如果是农户直销，直接返回结果//农户的源头批次号为空
		if (StringUtils.isBlank(productInfo.getIdHead_rep())){
			originList.add(buyFormFarmer(productInfo));
			return originList;
					
		}	
		//如果存在代理商，则依次溯源查询，直到查询到农户为止
		else {
			//没查到农户，则继续查询
			while (!StringUtils.isBlank(productInfo.getIdHead_rep())){
				//加
				originList.add(buyFormAgent(productInfo));
				//用源头批次号查，查完覆盖旧对象
				productInfo = productDao.getByProductId(productInfo.getIdHead_rep());
			}
			//查到农户
			originList.add(buyFormFarmer(productInfo));
		}
		return originList;
	}
	
	
	
	
	//农户注册方法
	@Override
	public void saveNhProduct(Product rp) {
		//获取拥有者的id
		Long idOwner_rep = rp.getIdOwner_rep();
		String strid = Long.toString(idOwner_rep);
		String productId = GenerateNumberUtils.generateProductId(strid);
		//因为是农户，所以源头号为空
		rp.setIdHead_rep(null);
		//设置用户类别
		rp.setUserCategory_reo("farmer");
		//设置批次号
		rp.setProductId_rep(productId);
		//设置剩余量
		rp.setReduceNum_rep(rp.getNumber_rep());
		productDao.saveOrUpdate(rp);
		
	}

	//获得农户仓库信息，参数获取从前端传过来的参数
	@Override
	public PageBean getFarmerRepository(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1、调用dao查询总记录
		Integer totalCount = productDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//2、获得Product的list
		List<Product> list = productDao.getPageList(dc,pb.getStart(),pb.getPageSize()); 
		Iterator<Product> it = list.iterator();
		//3、根据product的list改装成repository
		List<FarmerRepository> repositoryList = new ArrayList<FarmerRepository>();
		while (it.hasNext()){
			//获取到的临时对象
			Product productTemp = new Product();
			productTemp = it.next();
			//临时的封装对象
			FarmerRepository frtemp = new FarmerRepository();
			//封装农产品的批次号
			frtemp.setProductId(productTemp.getProductId_rep());
			//封装农产品名称
			frtemp.setProductName(productTemp.getName_rep());
			//先查，再封装
			Nongchang nc = nongchangDao.getById(productTemp.getIdPlace_rep());
			//封装农场名
			frtemp.setFarmName(nc.getName_ncfarm());
			//封装农产品数量
			frtemp.setNumberOfProduct(productTemp.getNumber_rep()+productTemp.getBuyUnit_rep());
			//封装产品余量
			frtemp.setRestOfProduct(productTemp.getReduceNum_rep()+productTemp.getBuyUnit_rep());
			//封装成本价
			frtemp.setProductPrice(productTemp.getBuyPrice_rep()+"元/"+productTemp.getBuyUnit_rep());
			//封装销售价格
			frtemp.setSellPrice(productTemp.getSellPrice_rep()+"元/"+productTemp.getSellUnit_rep());
			repositoryList.add(frtemp);
		}
		//将list中的数据反转
		Collections.reverse(repositoryList);
		pb.setList(repositoryList);
		return pb;
	}

	
	
	
	//根据批次号查询相应的产品
	@Override
	public Product getProductByPID(String productId) {
		return productDao.getByProductId(productId);
	}
	
	
	
	//农户修改农产品信息
	@Override
	public void changeProductInformation(Product pro) {
		//获取要修改的对象
		Product oldProductInfo = getProductByPID(pro.getProductId_rep());
		//修改农产品名称
		oldProductInfo.setName_rep(pro.getName_rep());
		//修改农产品数量
		oldProductInfo.setNumber_rep(pro.getNumber_rep());
		//修改产品余量
		oldProductInfo.setReduceNum_rep(pro.getReduceNum_rep());
		//修改入库计量单位
		oldProductInfo.setBuyUnit_rep(pro.getBuyUnit_rep());
		//修改成本单价（元）
		oldProductInfo.setBuyPrice_rep(pro.getBuyPrice_rep());
		//修改销售计量单位
		oldProductInfo.setSellUnit_rep(pro.getSellUnit_rep());
		//修改销售单价（元）
		oldProductInfo.setSellPrice_rep(pro.getSellPrice_rep());
		//调用dao层的方法修改数据
		productDao.saveOrUpdate(oldProductInfo);
		
	}

	
	
	//查询直销
	public Origin buyFormFarmer(Product productInfo){
		//根据product的信息查询农场信息
		Nongchang nc = nongchangDao.getById(productInfo.getIdPlace_rep());
		//转换成显示信息
		Origin originTemp = ChangeDataUtils.changeProductToOrigin(productInfo, nc.getName_ncfarm(), nc.getAddress_ncfarm());

		//返回
		return originTemp;
	}
	
	
	//代理商查询
	public Origin buyFormAgent(Product productInfo){		
		//根据product的信息查询代理商信息
		Shop shop = shopDao.getById(productInfo.getIdPlace_rep());
		//转换成显示信息
		Origin originTemp = ChangeDataUtils.changeProductToOrigin(productInfo, shop.getName_shop(), shop.getAddress_shop());
		//返回
		return originTemp;
	}
	
	
	
	//get/set方法
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public NongchangDao getNongchangDao() {
		return nongchangDao;
	}

	public void setNongchangDao(NongchangDao nongchangDao) {
		this.nongchangDao = nongchangDao;
	}
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}




	//保存代理商的产品
	@Override
	public void saveDLSProduct(Product rp) {
		Product byProductId = productDao.getByProductId(rp.getIdHead_rep());
		//获取拥有者的id
		Long idOwner_rep = rp.getIdOwner_rep();
		String strid = Long.toString(idOwner_rep);
		String productId = GenerateNumberUtils.generateProductId(strid);
		//设置用户类别
		rp.setUserCategory_reo("agent");
		//设置批次号
		rp.setProductId_rep(productId);
		//设置代理商剩余量
		rp.setReduceNum_rep(rp.getNumber_rep());
		
		
		//源头剩余量
		String rnum = byProductId.getReduceNum_rep();
		//购买数量
		String bnum = rp.getNumber_rep();
		double restnum = Double.parseDouble(rnum) - Double.parseDouble(bnum);
		String newrest = Double.toString(restnum);
		byProductId.setReduceNum_rep(newrest);
		productDao.saveOrUpdate(byProductId);
		productDao.saveOrUpdate(rp);
		Order byId = orderDao.getById(rp.getId_order());
		byId.setConditon_order("1");
		orderDao.saveOrUpdate(byId);
	}
	
	//代理商保存代理商的产品
	@Override
	public void saveDLSProduct1(Product rp) {
		Product byProductId = productDao.getByProductId(rp.getIdHead_rep());
		//获取拥有者的id
		Long idOwner_rep = rp.getIdOwner_rep();
		String strid = Long.toString(idOwner_rep);
		String productId = GenerateNumberUtils.generateProductId(strid);
		//设置用户类别
		rp.setUserCategory_reo("agent");
		//设置批次号
		rp.setProductId_rep(productId);
		//设置代理商剩余量
		rp.setReduceNum_rep(rp.getNumber_rep());
		
		
		//源头剩余量
		String rnum = byProductId.getReduceNum_rep();
		//购买数量
		String bnum = rp.getNumber_rep();
		double restnum = Double.parseDouble(rnum) - Double.parseDouble(bnum);
		String newrest = Double.toString(restnum);
		byProductId.setReduceNum_rep(newrest);
		productDao.saveOrUpdate(byProductId);
		productDao.saveOrUpdate(rp);
		Order byId = orderDao.getById(rp.getId_order());
		byId.setConditon_order("1");
		orderDao.saveOrUpdate(byId);
		
	}


	@Override
	public PageBean getAgentRepository(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1、调用dao查询总记录
		Integer totalCount = productDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//2、获得Product的list
		List<Product> list = productDao.getPageList(dc,pb.getStart(),pb.getPageSize()); 
		Iterator<Product> it = list.iterator();
		//3、根据product的list改装成repository
		List<FarmerRepository> repositoryList = new ArrayList<FarmerRepository>();
		while (it.hasNext()){
			//获取到的临时对象
			Product productTemp = new Product();
			productTemp = it.next();
			//临时的封装对象
			FarmerRepository frtemp = new FarmerRepository();
			//封装农产品的批次号
			frtemp.setProductId(productTemp.getProductId_rep());
			//封装农产品名称
			frtemp.setProductName(productTemp.getName_rep());
			//先查，再封装
			Shop shop = shopDao.getById(productTemp.getIdPlace_rep());
			//封装农场名
			frtemp.setFarmName(shop.getName_shop());
			//封装农产品数量
			frtemp.setNumberOfProduct(productTemp.getNumber_rep()+productTemp.getBuyUnit_rep());
			//封装产品余量
			frtemp.setRestOfProduct(productTemp.getReduceNum_rep()+productTemp.getBuyUnit_rep());
			//封装成本价
			frtemp.setProductPrice(productTemp.getBuyPrice_rep()+"元/"+productTemp.getBuyUnit_rep());
			//封装销售价格
			frtemp.setSellPrice(productTemp.getSellPrice_rep()+"元/"+productTemp.getSellUnit_rep());
			repositoryList.add(frtemp);
		}
		//将list中的数据反转
		Collections.reverse(repositoryList);
		pb.setList(repositoryList);
		return pb;
	}











	
	



	
	
	

}
