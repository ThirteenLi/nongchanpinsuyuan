package com.gap.domain;

/*

Create Table

CREATE TABLE `t_customer` (
  `id_cus` bigint(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_cus` varchar(255) DEFAULT NULL,
  `nickName_cus` varchar(255) DEFAULT NULL,
  `password_cus` varchar(255) DEFAULT NULL,
  `address_cus` varchar(255) DEFAULT NULL,
  `gender_cus` varchar(255) DEFAULT NULL,
  `birthday_cus` date DEFAULT '1990-01-01',
  `photo_cus` varchar(255) DEFAULT NULL,
  `condition_cus` tinyint(1) DEFAULT '1',
  `email_cus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cus`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

 */
public class Customer {
	private Long id_cus;
	private String phoneNumber_cus;
	private String nickName_cus;
	private String password_cus;
	private String address_cus;
	private String gender_cus;
	private String birthday_cus;
	private String photo_cus;
	private String email_cus;
	private String condition_cus;

	public Long getId_cus() {
		return id_cus;
	}
	public void setId_cus(Long id_cus) {
		this.id_cus = id_cus;
	}
	public String getPhoneNumber_cus() {
		return phoneNumber_cus;
	}
	public void setPhoneNumber_cus(String phoneNumber_cus) {
		this.phoneNumber_cus = phoneNumber_cus;
	}
	public String getNickName_cus() {
		return nickName_cus;
	}
	public void setNickName_cus(String nickName_cus) {
		this.nickName_cus = nickName_cus;
	}
	public String getPassword_cus() {
		return password_cus;
	}
	public void setPassword_cus(String password_cus) {
		this.password_cus = password_cus;
	}
	public String getAddress_cus() {
		return address_cus;
	}
	public void setAddress_cus(String address_cus) {
		this.address_cus = address_cus;
	}
	public String getGender_cus() {
		return gender_cus;
	}
	public void setGender_cus(String gender_cus) {
		this.gender_cus = gender_cus;
	}
	public String getBirthday_cus() {
		return birthday_cus;
	}
	public void setBirthday_cus(String birthday_cus) {
		this.birthday_cus = birthday_cus;
	}
	public String getPhoto_cus() {
		return photo_cus;
	}
	public void setPhoto_cus(String photo_cus) {
		this.photo_cus = photo_cus;
	}
	public String getEmail_cus() {
		return email_cus;
	}
	public void setEmail_cus(String email_cus) {
		this.email_cus = email_cus;
	}
	public String getCondition_cus() {
		return condition_cus;
	}
	public void setCondition_cus(String condition_cus) {
		this.condition_cus = condition_cus;
	}

	
}
