package com.gap.domain;


//订单
/**
Create Table

CREATE TABLE `t_order` (
  `id_order` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `sellerzl` varchar(255) DEFAULT NULL COMMENT '卖家类型',
  `sellerid` bigint(20) DEFAULT NULL COMMENT '卖家id',
  `buyerzl` varchar(255) DEFAULT NULL COMMENT '买家类型',
  `buyerid` bigint(20) DEFAULT NULL COMMENT '买家id',
  `productid` varchar(255) DEFAULT NULL COMMENT '产品id号',
  `buynumber` varchar(255) DEFAULT NULL COMMENT '成交数量',
  `id_shop` bigint(20) DEFAULT NULL COMMENT '商店id',
  `conditon_order` varchar(255) DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */
public class Order {
	private Long id_order;
	private String sellerzl;
	private Long sellerid;
	private String buyerzl;
	private Long buyerid;
	private String productid;
	private String buynumber;
	private Long id_shop;
	private String conditon_order;
	private String buyPrice;
	private String buyUnit;
	private String productName;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getId_order() {
		return id_order;
	}
	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}
	public String getSellerzl() {
		return sellerzl;
	}
	public void setSellerzl(String sellerzl) {
		this.sellerzl = sellerzl;
	}
	public Long getSellerid() {
		return sellerid;
	}
	public void setSellerid(Long sellerid) {
		this.sellerid = sellerid;
	}
	public String getBuyerzl() {
		return buyerzl;
	}
	public void setBuyerzl(String buyerzl) {
		this.buyerzl = buyerzl;
	}
	public Long getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getBuynumber() {
		return buynumber;
	}
	public void setBuynumber(String buynumber) {
		this.buynumber = buynumber;
	}
	public Long getId_shop() {
		return id_shop;
	}
	public void setId_shop(Long id_shop) {
		this.id_shop = id_shop;
	}
	public String getConditon_order() {
		return conditon_order;
	}
	public void setConditon_order(String conditon_order) {
		this.conditon_order = conditon_order;
	}
	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}
	public String getBuyUnit() {
		return buyUnit;
	}
	public void setBuyUnit(String buyUnit) {
		this.buyUnit = buyUnit;
	}






	
	
	
}
