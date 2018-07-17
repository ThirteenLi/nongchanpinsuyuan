package com.gap.domain;

/*
CREATE TABLE `t_agent` (
  `id_dls` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_dls` varchar(255) DEFAULT NULL,
  `password_dls` varchar(255) DEFAULT NULL,
  `realName_dls` varchar(255) DEFAULT NULL,
  `IDCardNum_dls` varchar(255) DEFAULT NULL,
  `pictureIDC_dls` varchar(255) DEFAULT NULL,
  `pictureIDCF_dls` varchar(255) DEFAULT NULL,
  `pictureIDCB_dls` varchar(255) DEFAULT NULL,
  `condition_dls` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_dls`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
 */
public class Agent {
	private Long id_dls;
	private String phoneNumber_dls;
	private String password_dls;
	private String realName_dls;
	private String gender_dls;
	private String email_dls;
	private String IDCardNum_dls;
	private String pictureIDCF_dls;
	private String pictureIDCB_dls;
	private String pictureIDC_dls;
	private String condition_dls;
	public Long getId_dls() {
		return id_dls;
	}
	public void setId_dls(Long id_dls) {
		this.id_dls = id_dls;
	}
	public String getPhoneNumber_dls() {
		return phoneNumber_dls;
	}
	public void setPhoneNumber_dls(String phoneNumber_dls) {
		this.phoneNumber_dls = phoneNumber_dls;
	}
	public String getPassword_dls() {
		return password_dls;
	}
	public void setPassword_dls(String password_dls) {
		this.password_dls = password_dls;
	}
	public String getRealName_dls() {
		return realName_dls;
	}
	public void setRealName_dls(String realName_dls) {
		this.realName_dls = realName_dls;
	}
	public String getGender_dls() {
		return gender_dls;
	}
	public void setGender_dls(String gender_dls) {
		this.gender_dls = gender_dls;
	}
	public String getEmail_dls() {
		return email_dls;
	}
	public void setEmail_dls(String email_dls) {
		this.email_dls = email_dls;
	}
	public String getIDCardNum_dls() {
		return IDCardNum_dls;
	}
	public void setIDCardNum_dls(String iDCardNum_dls) {
		IDCardNum_dls = iDCardNum_dls;
	}
	public String getPictureIDCF_dls() {
		return pictureIDCF_dls;
	}
	public void setPictureIDCF_dls(String pictureIDCF_dls) {
		this.pictureIDCF_dls = pictureIDCF_dls;
	}
	public String getPictureIDCB_dls() {
		return pictureIDCB_dls;
	}
	public void setPictureIDCB_dls(String pictureIDCB_dls) {
		this.pictureIDCB_dls = pictureIDCB_dls;
	}
	public String getPictureIDC_dls() {
		return pictureIDC_dls;
	}
	public void setPictureIDC_dls(String pictureIDC_dls) {
		this.pictureIDC_dls = pictureIDC_dls;
	}
	public String getCondition_dls() {
		return condition_dls;
	}
	public void setCondition_dls(String condition_dls) {
		this.condition_dls = condition_dls;
	}

	
	
}
