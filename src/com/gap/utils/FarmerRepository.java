package com.gap.utils;


/**
 * 农户仓库显示类，负责向前台展示农户的农产品
 */
public class FarmerRepository {
	private String productId;  //农产品的批次号
	private String productName;  //产品名称
	private String farmName;     //农场名称	
	private String numberOfProduct;  //农产品的数量
	private String restOfProduct; //农产品余量
	private String productPrice; //农产品成本价
	private String sellPrice;  //农产品的销售价格
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public String getNumberOfProduct() {
		return numberOfProduct;
	}
	public void setNumberOfProduct(String numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}
	public String getRestOfProduct() {
		return restOfProduct;
	}
	public void setRestOfProduct(String restOfProduct) {
		this.restOfProduct = restOfProduct;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	@Override
	public String toString() {
		return "FarmerRepository [productId=" + productId + ", productName=" + productName + ", farmName=" + farmName
				+ ", numberOfProduct=" + numberOfProduct + ", restOfProduct=" + restOfProduct + ", productPrice="
				+ productPrice + ", sellPrice=" + sellPrice + "]";
	}
	
	
}
