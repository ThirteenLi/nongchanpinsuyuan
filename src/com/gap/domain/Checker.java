package com.gap.domain;

/*
CREATE TABLE `t_manager` (
`id_gly` bigint(11) NOT NULL AUTO_INCREMENT,
`username_gly` varchar(255) DEFAULT NULL,
`password_gly` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id_gly`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8

*/
public class Checker {
	private Long id_zjy;
	private String username_zjy;
	private String password_zjy;
	private String realName_zjy;
	private String phone_zjy;
	private String qq_zjy;
	private String condition_zjy;
	public Long getId_zjy() {
		return id_zjy;
	}
	public void setId_zjy(Long id_zjy) {
		this.id_zjy = id_zjy;
	}
	public String getUsername_zjy() {
		return username_zjy;
	}
	public void setUsername_zjy(String username_zjy) {
		this.username_zjy = username_zjy;
	}
	public String getPassword_zjy() {
		return password_zjy;
	}
	public void setPassword_zjy(String password_zjy) {
		this.password_zjy = password_zjy;
	}
	public String getRealName_zjy() {
		return realName_zjy;
	}
	public void setRealName_zjy(String realName_zjy) {
		this.realName_zjy = realName_zjy;
	}
	public String getPhone_zjy() {
		return phone_zjy;
	}
	public void setPhone_zjy(String phone_zjy) {
		this.phone_zjy = phone_zjy;
	}
	public String getQq_zjy() {
		return qq_zjy;
	}
	public void setQq_zjy(String qq_zjy) {
		this.qq_zjy = qq_zjy;
	}
	public String getCondition_zjy() {
		return condition_zjy;
	}
	public void setCondition_zjy(String condition_zjy) {
		this.condition_zjy = condition_zjy;
	}


}
