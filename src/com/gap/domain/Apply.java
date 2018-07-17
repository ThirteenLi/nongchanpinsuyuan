package com.gap.domain;


/*Create Table

CREATE TABLE `t_apply` (
  `id_message` bigint(20) NOT NULL AUTO_INCREMENT,
  `usercategory` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `applycategory` varchar(255) DEFAULT NULL,
  `userapply` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_message`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8*/

public class Apply {
	private Long id_message;      //主键自增
	private String usercategory;   //用户类型
	private String userid;        //用户号
	private String applycategory;  //变更的种类，修改删除
	private String userapply;     //申请内容
	private String zt;    //该申请的状态
	
	public Long getId_message() {
		return id_message;
	}
	public void setId_message(Long id_message) {
		this.id_message = id_message;
	}
	public String getUsercategory() {
		return usercategory;
	}
	public void setUsercategory(String usercategory) {
		this.usercategory = usercategory;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getApplycategory() {
		return applycategory;
	}
	public void setApplycategory(String applycategory) {
		this.applycategory = applycategory;
	}
	public String getUserapply() {
		return userapply;
	}
	public void setUserapply(String userapply) {
		this.userapply = userapply;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}

	
}
