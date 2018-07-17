package com.gap.domain;

/*
CREATE TABLE `t_manager` (
`id_gly` bigint(11) NOT NULL AUTO_INCREMENT,
`username_gly` varchar(255) DEFAULT NULL,
`password_gly` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id_gly`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8

*/
public class toAdministrar {
	private Long id_gly;
	private String username_gly;
	private String password_gly;
	public Long getId_gly() {
		return id_gly;
	}
	public void setId_gly(Long id_gly) {
		this.id_gly = id_gly;
	}
	public String getUsername_gly() {
		return username_gly;
	}
	public void setUsername_gly(String username_gly) {
		this.username_gly = username_gly;
	}
	public String getPassword_gly() {
		return password_gly;
	}
	public void setPassword_gly(String password_gly) {
		this.password_gly = password_gly;
	}
	
}
