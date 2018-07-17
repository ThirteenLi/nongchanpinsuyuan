package com.gap.utils;

//溯源类，用于前台展示
public class Origin {
	private String productId;  //产品号
	private String productName;  //农产品名
	private String pickTime;  //农产品采摘时间
	private String placeName;   //所在地名
	private String placeAddress;  //所在地址
	private String price;  //价格，只能查看到上一级的价格,之前的价格无法查看
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
	public String getPickTime() {
		return pickTime;
	}
	public void setPickTime(String pickTime) {
		this.pickTime = pickTime;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceAddress() {
		return placeAddress;
	}
	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Origin [productId=" + productId + ", productName=" + productName + ", pickTime=" + pickTime
				+ ", placeName=" + placeName + ", placeAddress=" + placeAddress + ", price=" + price + "]";
	}
	
	
	
}
