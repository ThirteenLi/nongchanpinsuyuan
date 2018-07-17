package com.gap.domain;


public class Nongchang {
	private Long id_ncfarm;
	private String name_ncfarm;
	private String address_ncfarm;
	private String area_ncfarm;
	private String areaUnit_ncfarm;
	private String traffic_ncfarm;
	private String picture_ncfarm;
	private String mainProduct_ncfarm;
	private Farmer farmer;
	private String condition_ncfarm;
	private Long id_nh;


	
	public Long getId_ncfarm() {
		return id_ncfarm;
	}

	public void setId_ncfarm(Long id_ncfarm) {
		this.id_ncfarm = id_ncfarm;
	}
	
	public String getName_ncfarm() {
		return name_ncfarm;
	}

	public void setName_ncfarm(String name_ncfarm) {
		this.name_ncfarm = name_ncfarm;
	}

	public String getAddress_ncfarm() {
		return address_ncfarm;
	}

	public void setAddress_ncfarm(String address_ncfarm) {
		this.address_ncfarm = address_ncfarm;
	}

	public String getArea_ncfarm() {
		return area_ncfarm;
	}

	public void setArea_ncfarm(String area_ncfarm) {
		this.area_ncfarm = area_ncfarm;
	}

	public String getAreaUnit_ncfarm() {
		return areaUnit_ncfarm;
	}

	public void setAreaUnit_ncfarm(String areaUnit_ncfarm) {
		this.areaUnit_ncfarm = areaUnit_ncfarm;
	}

	public String getTraffic_ncfarm() {
		return traffic_ncfarm;
	}

	public void setTraffic_ncfarm(String traffic_ncfarm) {
		this.traffic_ncfarm = traffic_ncfarm;
	}

	
	public String getMainProduct_ncfarm() {
		return mainProduct_ncfarm;
	}

	public void setMainProduct_ncfarm(String mainProduct_ncfarm) {
		this.mainProduct_ncfarm = mainProduct_ncfarm;
	}

	public String getPicture_ncfarm() {
		return picture_ncfarm;
	}

	public void setPicture_ncfarm(String picture_ncfarm) {
		this.picture_ncfarm = picture_ncfarm;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	

	public Long getId_nh() {
		return id_nh;
	}

	public void setId_nh(Long id_nh) {
		this.id_nh = id_nh;
	}

	
	
	public String getCondition_ncfarm() {
		return condition_ncfarm;
	}

	public void setCondition_ncfarm(String condition_ncfarm) {
		this.condition_ncfarm = condition_ncfarm;
	}

	@Override
	public String toString() {
		return "Nongchang [id_ncfarm=" + id_ncfarm + ", address_ncfarm=" + address_ncfarm + ", area_ncfarm="
				+ area_ncfarm + ", areaUnit_ncfarm=" + areaUnit_ncfarm + ", traffic_ncfarm=" + traffic_ncfarm
				+ ", picture_ncfarm=" + picture_ncfarm + ", farmer=" + farmer + ", id_nh=" + id_nh + "]";
	}
	
	
	
}
