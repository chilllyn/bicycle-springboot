package com.aowin.model;

public class BicycleStation {
	private Integer stationId;
	private String stationCode;
	private String stationName;
	private Integer bicyclePileNum;
	private String address;

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Integer getBicyclePileNum() {
		return bicyclePileNum;
	}

	public void setBicyclePileNum(Integer bicyclePileNum) {
		this.bicyclePileNum = bicyclePileNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
