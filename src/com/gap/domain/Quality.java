package com.gap.domain;
/*


Create Table

CREATE TABLE `t_quality` (
  `id_zl` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id号',
  `id_pro` varchar(255) DEFAULT NULL COMMENT '产品号',
  `ny` varchar(255) DEFAULT NULL COMMENT '农药残留',
  `harm` varchar(255) DEFAULT NULL COMMENT '有害物质评分',
  `yjw` varchar(255) DEFAULT NULL COMMENT '总评',
  PRIMARY KEY (`id_zl`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8


 */

public class Quality {
	private Long id_zl;  
	private String id_pro;
	private String ny;
	private String harm;
	private String yjw;
	public Long getId_zl() {
		return id_zl;
	}
	public void setId_zl(Long id_zl) {
		this.id_zl = id_zl;
	}
	public String getId_pro() {
		return id_pro;
	}
	public void setId_pro(String id_pro) {
		this.id_pro = id_pro;
	}
	public String getNy() {
		return ny;
	}
	public void setNy(String ny) {
		this.ny = ny;
	}
	public String getHarm() {
		return harm;
	}
	public void setHarm(String harm) {
		this.harm = harm;
	}
	public String getYjw() {
		return yjw;
	}
	public void setYjw(String yjw) {
		this.yjw = yjw;
	}
	
	

	
	
	
}
