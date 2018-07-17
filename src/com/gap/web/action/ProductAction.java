package com.gap.web.action;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gap.domain.Nongchang;
import com.gap.domain.Product;
import com.gap.domain.Shop;
import com.gap.service.ProductService;
import com.gap.service.ShopService;
import com.gap.utils.FarmerRepository;
import com.gap.utils.GenerateQRCode;
import com.gap.utils.Origin;
import com.gap.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	Product product = new Product();
	ProductService productService;
	ShopService shopService;
	

	//当前页
	private Integer currentPage;
	//每页大小
	private Integer pageSize;	
	
	HttpServletResponse response = ServletActionContext.getResponse();
	
	private Long id_dls;
	
	//溯源查询
	public String searchOriginInformation() throws Exception{
		
		try{
			//调用service层的方法查询溯源信息list
			List<Origin> originList = productService.getOriginInfromationList(product.getProductId_rep());
			ActionContext.getContext().getSession().put("originList", originList);
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "error";
		}
		return "searchOriginInformation";
	}
	
	
	//代理商溯源查询
	public String AgentSearch() throws Exception{
		
		try{
			//调用service层的方法查询溯源信息list
			List<Origin> originList = productService.getOriginInfromationList(product.getProductId_rep());
			ActionContext.getContext().getSession().put("originList", originList);
			ActionContext.getContext().getSession().put("pid", product.getProductId_rep());
		}catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("searchError", e.getMessage());
			return "searchError";
		}
		return "AgentSearch";
	}
	
	
	//代理商提出购买申请
	public String ApplyToBuy(){
		Product productByPID = productService.getProductByPID(product.getProductId_rep());
		DetachedCriteria dc = DetachedCriteria.forClass(Shop.class);
		dc.add(Restrictions.eq("agent.id_dls", id_dls) );
		dc.add(Restrictions.eq("condition_shop", "1") );	
		PageBean pb = shopService.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("agentpageBean", pb);
		ActionContext.getContext().getSession().put("productByPID", productByPID);
		return "applyToBuy";
	}
	
	
	//农户生成溯源二维码
	public String generateQRC() throws Exception{		
		BufferedImage bi = GenerateQRCode.generateQRCode(product);
		ImageIO.write(bi, "jpg", response.getOutputStream());  

		return "generateQRC";
	}
	
	
	//农户保存产品
	public String NHSaveProduct() throws Exception{
		productService.saveNhProduct(product);
		return "nhaddsuccess";
	}
	
	
	//农户保存产品
	public String DLSSaveProduct() throws Exception{
		productService.saveDLSProduct(product);
		return "dlsaddsuccess";
	}

	
	//代理商保存产品
	public String DLSSaveProduct1() throws Exception{
		productService.saveDLSProduct1(product);
		return "dlsaddsuccess1";
	}
	
	//农户查询仓库
	public String NHGetRepository(){
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.eq("userCategory_reo", "farmer"));
		dc.add(Restrictions.eq("idOwner_rep", product.getIdOwner_rep()));
		PageBean pb = productService.getFarmerRepository(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("farmerRepositoryList", pb);
		return "NHGetRepository";
	}
	
	
	//代理商查询仓库
	public String dlsGetRepository(){
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.eq("userCategory_reo", "agent"));
		dc.add(Restrictions.eq("idOwner_rep", product.getIdOwner_rep()));
		PageBean pb = productService.getAgentRepository(dc, currentPage, pageSize);
		ActionContext.getContext().getSession().put("agnetRepositoryList", pb);
		return "dlsGetRepository";
	}
	
	//农户查询对应的农产品在库信息
	public String NHGetOneProduct(){
		//调用service层的方法，根据PID查询对应批次的农产品
		Product productByPID = productService.getProductByPID(product.getProductId_rep());
		ActionContext.getContext().getSession().put("productByPID", productByPID);
		return "NHGetOneProduct";
	}
	
	
	//代理商对应的农产品在库信息
	public String DLSGetOneProduct(){
		//调用service层的方法，根据PID查询对应批次的农产品
		Product productByPID = productService.getProductByPID(product.getProductId_rep());
		ActionContext.getContext().getSession().put("productByPID", productByPID);
		return "DLSGetOneProduct";
	}
	
	
	//农户修改产品信息
	public String NHModifyProductInfo(){
		//调用service层的方法修改产品信息
		productService.changeProductInformation(product);
		return "NHModifyProductInfo";
	}
	
	
	
	//代理商修改产品信息
	public String DLSModifyProductInfo(){
		//调用service层的方法修改产品信息
		productService.changeProductInformation(product);
		return "DLSModifyProductInfo";
	}
	
	@Override
	public Product getModel() {
		return product;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
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


	public Long getId_dls() {
		return id_dls;
	}


	public void setId_dls(Long id_dls) {
		this.id_dls = id_dls;
	}


	public ShopService getShopService() {
		return shopService;
	}


	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}



}
