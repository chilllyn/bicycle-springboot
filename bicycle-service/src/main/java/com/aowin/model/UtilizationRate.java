package com.aowin.model;

public class UtilizationRate {

	private Integer stationId;
	private String stationCode;
	private String stationName;
	private Integer bicyclePileNum;

	private Double avgBorrow;
	private Double avgReturn;
	private Double avgFrom;
	private Double avgTo;
	private Double avgRepairFrom;
	private Double avgRepairTo;

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

	public Double getAvgBorrow() {
		return avgBorrow;
	}

	public void setAvgBorrow(Double avgBorrow) {
		this.avgBorrow = avgBorrow;
	}

	public Double getAvgReturn() {
		return avgReturn;
	}

	public void setAvgReturn(Double avgReturn) {
		this.avgReturn = avgReturn;
	}

	public Double getAvgFrom() {
		return avgFrom;
	}

	public void setAvgFrom(Double avgFrom) {
		this.avgFrom = avgFrom;
	}

	public Double getAvgTo() {
		return avgTo;
	}

	public void setAvgTo(Double avgTo) {
		this.avgTo = avgTo;
	}

	public Double getAvgRepairFrom() {
		return avgRepairFrom;
	}

	public void setAvgRepairFrom(Double avgRepairFrom) {
		this.avgRepairFrom = avgRepairFrom;
	}

	public Double getAvgRepairTo() {
		return avgRepairTo;
	}

	public void setAvgRepairTo(Double avgRepairTo) {
		this.avgRepairTo = avgRepairTo;
	}
}
