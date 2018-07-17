package com.gap.domain;
/*

Create Table

CREATE TABLE `repositoryproduct` (
  `id_rep` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '批次编号',
  `idHead_rep` varchar(255) DEFAULT NULL COMMENT '上一级源头批次编号',
  `productId_rep` varchar(255) DEFAULT NULL COMMENT '产品批次号',
  `userCategory_reo` varchar(255) DEFAULT NULL COMMENT '用户类型',
  `idOwner_rep` bigint(20) DEFAULT NULL COMMENT '批次拥有者的id号',
  `idPlace_rep` bigint(20) DEFAULT NULL COMMENT '产品所在地id号',
  `name_rep` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `number_rep` float DEFAULT NULL COMMENT '产品总量',
  `reduceNum_rep` float DEFAULT NULL COMMENT '产品余量',
  `buyUnit_rep` varchar(255) DEFAULT NULL COMMENT '买入计量单位',
  `buyPrice_rep` float DEFAULT NULL COMMENT '买入总价',
  `sellUnit_rep` varchar(255) DEFAULT NULL COMMENT '销售计量单位',
  `sellPrice_rep` float DEFAULT NULL COMMENT '销售单价',
  PRIMARY KEY (`id_rep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */

public class Product {
	private Long id_rep;  
	private String idHead_rep;
	private String productId_rep;
	private String userCategory_reo;
	private Long idOwner_rep;
	private Long idPlace_rep;
	private String name_rep;
	private String number_rep;
	private String reduceNum_rep;
	private String buyUnit_rep;  //进货价单位
	private String buyPrice_rep;
	private String sellUnit_rep;  //出售单位
	private String sellPrice_rep;
	
	
	private Long id_order;
	
	
	
	public Long getId_order() {
		return id_order;
	}
	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}
	public Long getId_rep() {
		return id_rep;
	}
	public void setId_rep(Long id_rep) {
		this.id_rep = id_rep;
	}
	public String getIdHead_rep() {
		return idHead_rep;
	}
	public void setIdHead_rep(String idHead_rep) {
		this.idHead_rep = idHead_rep;
	}
	public String getProductId_rep() {
		return productId_rep;
	}
	public void setProductId_rep(String productId_rep) {
		this.productId_rep = productId_rep;
	}
	public String getUserCategory_reo() {
		return userCategory_reo;
	}
	public void setUserCategory_reo(String userCategory_reo) {
		this.userCategory_reo = userCategory_reo;
	}
	public Long getIdOwner_rep() {
		return idOwner_rep;
	}
	public void setIdOwner_rep(Long idOwner_rep) {
		this.idOwner_rep = idOwner_rep;
	}
	public Long getIdPlace_rep() {
		return idPlace_rep;
	}
	public void setIdPlace_rep(Long idPlace_rep) {
		this.idPlace_rep = idPlace_rep;
	}
	public String getName_rep() {
		return name_rep;
	}
	public void setName_rep(String name_rep) {
		this.name_rep = name_rep;
	}
	public String getNumber_rep() {
		return number_rep;
	}
	public void setNumber_rep(String number_rep) {
		this.number_rep = number_rep;
	}
	public String getReduceNum_rep() {
		return reduceNum_rep;
	}
	public void setReduceNum_rep(String reduceNum_rep) {
		this.reduceNum_rep = reduceNum_rep;
	}
	public String getBuyUnit_rep() {
		return buyUnit_rep;
	}
	public void setBuyUnit_rep(String buyUnit_rep) {
		this.buyUnit_rep = buyUnit_rep;
	}
	public String getBuyPrice_rep() {
		return buyPrice_rep;
	}
	public void setBuyPrice_rep(String buyPrice_rep) {
		this.buyPrice_rep = buyPrice_rep;
	}
	public String getSellUnit_rep() {
		return sellUnit_rep;
	}
	public void setSellUnit_rep(String sellUnit_rep) {
		this.sellUnit_rep = sellUnit_rep;
	}
	public String getSellPrice_rep() {
		return sellPrice_rep;
	}
	public void setSellPrice_rep(String sellPrice_rep) {
		this.sellPrice_rep = sellPrice_rep;
	}

	


	
	
	
}
