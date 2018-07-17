package com.gap.domain;


public class Shop {
	private Long id_shop;
	private String name_shop;
	private String address_shop;
	private String traffic_shop;
	private String mainProduct_shop;
	private String picture_shop;
	private String condition_shop;
	private Agent agent;

	private Long id_dls;

	public Long getId_shop() {
		return id_shop;
	}

	public void setId_shop(Long id_shop) {
		this.id_shop = id_shop;
	}

	public String getName_shop() {
		return name_shop;
	}

	public void setName_shop(String name_shop) {
		this.name_shop = name_shop;
	}

	public String getAddress_shop() {
		return address_shop;
	}

	public void setAddress_shop(String address_shop) {
		this.address_shop = address_shop;
	}

	public String getTraffic_shop() {
		return traffic_shop;
	}

	public void setTraffic_shop(String traffic_shop) {
		this.traffic_shop = traffic_shop;
	}

	public String getMainProduct_shop() {
		return mainProduct_shop;
	}

	public void setMainProduct_shop(String mainProduct_shop) {
		this.mainProduct_shop = mainProduct_shop;
	}

	public String getPicture_shop() {
		return picture_shop;
	}

	public void setPicture_shop(String picture_shop) {
		this.picture_shop = picture_shop;
	}

	public String getCondition_shop() {
		return condition_shop;
	}

	public void setCondition_shop(String condition_shop) {
		this.condition_shop = condition_shop;
	}



	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Long getId_dls() {
		return id_dls;
	}

	public void setId_dls(Long id_dls) {
		this.id_dls = id_dls;
	}



	
	
	
}
