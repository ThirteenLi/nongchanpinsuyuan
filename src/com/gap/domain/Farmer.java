package com.gap.domain;

import java.util.Set;
import javax.persistence.OneToMany;

/*


Create Table

CREATE TABLE `t_farmer` (
  `id_nh` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_nh` varchar(255) DEFAULT NULL,
  `password_nh` varchar(255) DEFAULT NULL,
  `email_nh` varchar(255) DEFAULT NULL,
  `IDCardNum_nh` varchar(255) DEFAULT NULL,
  `realName_nh` varchar(255) DEFAULT NULL,
  `gender_nh` varchar(255) DEFAULT NULL,
  `pictureIDCF_nh` varchar(255) DEFAULT NULL,
  `pictureIDCB_nh` varchar(255) DEFAULT NULL,
  `pictureIDC_nh` varchar(255) DEFAULT NULL,
  `condition_nh` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_nh`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8


 */
public class Farmer {
	private Long id_nh;
	private String phoneNumber_nh;
	private String password_nh;
	private String email_nh;
	private String iDCardNum_nh;
	private String realName_nh;
	private String gender_nh;
	private String pictureIDCF_nh;
	private String pictureIDCB_nh;
	private String pictureIDC_nh;
	private String condition_nh;

	
	private Set<Nongchang> nongchangs;
	
	public Long getId_nh() {
		return id_nh;
	}
	public void setId_nh(Long id_nh) {
		this.id_nh = id_nh;
	}
	public String getPhoneNumber_nh() {
		return phoneNumber_nh;
	}
	public void setPhoneNumber_nh(String phoneNumber_nh) {
		this.phoneNumber_nh = phoneNumber_nh;
	}
	public String getPassword_nh() {
		return password_nh;
	}
	public void setPassword_nh(String password_nh) {
		this.password_nh = password_nh;
	}
	public String getEmail_nh() {
		return email_nh;
	}
	public void setEmail_nh(String email_nh) {
		this.email_nh = email_nh;
	}
	public String getIDCardNum_nh() {
		return iDCardNum_nh;
	}
	public void setIDCardNum_nh(String iDCardNum_nh) {
		this.iDCardNum_nh = iDCardNum_nh;
	}
	public String getRealName_nh() {
		return realName_nh;
	}
	public void setRealName_nh(String realName_nh) {
		this.realName_nh = realName_nh;
	}
	public String getGender_nh() {
		return gender_nh;
	}
	public void setGender_nh(String gender_nh) {
		this.gender_nh = gender_nh;
	}
	public String getPictureIDCF_nh() {
		return pictureIDCF_nh;
	}
	public void setPictureIDCF_nh(String pictureIDCF_nh) {
		this.pictureIDCF_nh = pictureIDCF_nh;
	}
	public String getPictureIDCB_nh() {
		return pictureIDCB_nh;
	}
	public void setPictureIDCB_nh(String pictureIDCB_nh) {
		this.pictureIDCB_nh = pictureIDCB_nh;
	}
	public String getPictureIDC_nh() {
		return pictureIDC_nh;
	}
	public void setPictureIDC_nh(String pictureIDC_nh) {
		this.pictureIDC_nh = pictureIDC_nh;
	}
	public String getCondition_nh() {
		return condition_nh;
	}
	public void setCondition_nh(String condition_nh) {
		this.condition_nh = condition_nh;
	}
	public Set<Nongchang> getNongchangs() {
		return nongchangs;
	}
	
	
	@OneToMany(targetEntity=Nongchang.class,mappedBy="farmer")
	public void setNongchangs(Set<Nongchang> nongchangs) {
		this.nongchangs = nongchangs;
	}

	
	
	
}
