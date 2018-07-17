package com.gap.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.gap.domain.Product;
import com.gap.utils.Origin;
import com.gap.utils.PageBean;

public interface ProductService {

	//将农户的产品保存进仓库
	public void saveNhProduct(Product product);
		
	//获取农户的仓库信息
	public PageBean getFarmerRepository(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	//根据批次号获取对应的农产品
	public	Product getProductByPID(String productId);
		
	//农户修改农产品信息
	public void changeProductInformation(Product pro);
	
	
	//查询溯源信息
	public List<Origin> getOriginInfromationList(String productId);

	
	//将代理商的产品保存进仓库
	public void saveDLSProduct(Product rp);

	public PageBean getAgentRepository(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//代理商保存农产品
	public void saveDLSProduct1(Product product);
}
